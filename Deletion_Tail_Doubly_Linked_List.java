/*
// Definition for a Node.
class ListNode {
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode();
    public ListNode(int data);
    public ListNode(int data, ListNode prev, ListNode next);
};
*/
class Solution {
    public ListNode deleteTail(ListNode head) {
        if(head == null || head.next == null) return null; // 1. Check empty or single node

        ListNode tail = head; // 2. Start from head

        while(tail.next != null) {
            tail = tail.next; // 3. Find the last node
        }

        ListNode newTail = tail.prev; // 4. Get second-last node

        newTail.next = null; // 5. Disconnect last node forward

        tail.prev = null; // 6. Remove last node's backward link

        return head; // 7. Return original head
    }
}
