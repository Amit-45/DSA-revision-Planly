class Solution {
    public ListNode insertBeforeHead(ListNode head, int X) {
        ListNode newHead = new ListNode(X, null, head); // 1. Create node: prev=null, next=old head

        if(head != null) head.prev = newHead; // 2. Old head points back to new node

        return newHead; // 3. Return new head
    }
}
