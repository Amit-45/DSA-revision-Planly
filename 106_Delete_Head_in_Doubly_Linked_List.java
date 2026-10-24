class Solution {
    public ListNode deleteHead(ListNode head) {
        if(head == null || head.next == null) return null; // 1. Empty or single node?

        ListNode prev = head; // 2. Store old head

        head = head.next; // 3. Move head to next node

        head.prev = null; // 4. Remove backward link

        prev.next = null; // 5. Disconnect old head

        return head; // 6. Return new head
    }
}
