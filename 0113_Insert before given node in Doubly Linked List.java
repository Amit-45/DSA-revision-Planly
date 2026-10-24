class Solution {
    public void insertBeforeNode(ListNode node, int X) {
        ListNode prev = node.prev; // 1. Get previous node
        ListNode newNode = new ListNode(X, prev, node); // 2. Create new node
        prev.next = newNode; // 3. Connect previous node
        node.prev = newNode; // 4. Connect given node
    }
}
