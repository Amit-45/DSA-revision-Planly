class Solution {
    public ListNode insertAtHead(ListNode head, int X) {
        ListNode newnode = new ListNode(X); // 1. Create new node

        newnode.next = head; // 2. Link new node to current head

        head = newnode; // 3. Make new node the head

        return head; // 4. Return updated head
    }
}
