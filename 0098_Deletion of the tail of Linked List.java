class Solution {
    public ListNode deleteTail(ListNode head) {
        if(head == null) return null; // 1. Empty list: nothing to delete

        if(head.next == null) return null; // 2. Single node: list becomes empty

        ListNode temp = head; // 3. Start from head

        while(temp.next.next != null) { // 4. Find second-last node
            temp = temp.next; // 5. Move to next node
        }

        temp.next = null; // 6. Disconnect the last node

        return head; // 7. Return updated list
    }
}
