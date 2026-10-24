class Solution {
   //SLOW AND FAST POINTERS
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // 1. Move slow by 1 step
            fast = fast.next.next; // 2. Move fast by 2 steps
        }

        return slow; // 3. Return middle node
    }
}
