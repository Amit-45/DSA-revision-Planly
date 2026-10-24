class Solution {
    public ListNode insertAtTail(ListNode head, int X) {
        if(head == null) return new ListNode(X); // 1. Empty list: new node becomes head

        ListNode temp = head; // 2. Start from head

        while(temp.next != null) {
            temp = temp.next; // 3. Find the last node
        }

        ListNode newNode = new ListNode(X); // 4. Create new node

        temp.next = newNode; // 5. Link last node to new node

        return head; // 6. Return original head
    }
}
