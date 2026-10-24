class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head; // 1. Start together

        while(fast != null && fast.next != null) {
            slow = slow.next; // 2. Move slow one step
            fast = fast.next.next; // 3. Move fast two steps

            if(slow == fast) return true; // 4. Meet = loop
        }

        return false; // 5. Reach null = no loop
    }
}
