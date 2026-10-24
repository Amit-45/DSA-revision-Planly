class Solution {
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // 1. Move slow +1
            fast = fast.next.next; // 2. Move fast +2

            if(slow == fast) { // 3. Loop detected
                int count = 1;
                fast = fast.next;

                while(slow != fast) {
                    count++; // 4. Count loop nodes
                    fast = fast.next; // Move fast +1
                }

                return count; // 5. Return loop length
            }
        }

        return 0; // No loop
    }
}
