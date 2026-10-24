class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null; // 1. Handle edge cases

        ListNode slow = head;
        ListNode fast = head.next.next; // 2. Start fast ahead

        while(fast != null && fast.next != null) {
            slow = slow.next; // 3. Move slow one step
            fast = fast.next.next; // 4. Move fast two steps
        }

        slow.next = slow.next.next; // 5. Delete middle
        return head; // 6. Return updated list
    }
}
