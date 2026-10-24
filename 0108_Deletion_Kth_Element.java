class Solution {
    public ListNode deleteKthElement(ListNode head, int k) {
        if(head == null) return null; // 1. Check empty list

        ListNode kNode = head;
        int count = 0;

        while(kNode != null) {
            count++; // 2. Count nodes to find kth
            if(count == k) break;
            kNode = kNode.next;
        }

        if(kNode == null) return head; // 3. Check valid k

        ListNode prev = kNode.prev; // 4. Get previous node
        ListNode front = kNode.next; // 5. Get next node

        if(prev == null && front == null) return null; // 6. Only node

        else if(prev == null) { // 7. Delete head
            head = front;
            front.prev = null;
        }
        else if(front == null) { // 8. Delete tail
            prev.next = null;
        }
        else { // 9. Delete middle node
            prev.next = front;
            front.prev = prev;
        }

        return head; // 10. Return updated head
    }
}
