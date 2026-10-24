class Solution {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null) {
            ListNode front = temp.next; // 1. Save next node
            temp.next = prev; // 2. Reverse link
            prev = temp; // 3. Move prev
            temp = front; // 4. Move temp
        }
        return prev; // 5. Return new head
    }

    public ListNode getKthNode(ListNode temp, int k) {
        k--; // 1. Adjust k

        while(temp != null && k > 0) {
            temp = temp.next; // 2. Move to next node
            k--; // 3. Decrease k
        }

        return temp; // 4. Return kth node
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null) {
            ListNode kThNode = getKthNode(temp, k); // 1. Find kth node

            if(kThNode == null) { // 2. Check incomplete group
                if(prevLast != null) prevLast.next = temp;
                break;
            }

            ListNode nextNode = kThNode.next; // 3. Save next group
            kThNode.next = null; // 4. Disconnect group

            reverseLinkedList(temp); // 5. Reverse current group

            if(temp == head) {
                head = kThNode; // 6. Update head
            } else {
                prevLast.next = kThNode; // 7. Connect previous group
            }

            prevLast = temp; // 8. Save last node
            temp = nextNode; // 9. Move to next group
        }

        return head; // 10. Return updated list
    }
}
