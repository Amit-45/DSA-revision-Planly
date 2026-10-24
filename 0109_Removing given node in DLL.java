class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node.prev; // 1. Get previous node
        ListNode front = node.next; // 2. Get next node

        if(prev != null) prev.next = front; // 3. Previous connects to next
        if(front != null) front.prev = prev; // 4. Next connects to previous

        node.prev = null; // 5. Disconnect backward link
        node.next = null; // 6. Disconnect forward link
    }
}
