/*
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/
class Solution {
    public ListNode deleteKthNode(ListNode head, int k) {
        if(head == null) return null; // Is the list empty?

        if(k == 1) return head.next; // Are we deleting the head?

        ListNode temp = head; // Start from the first node

        for(int i = 0; temp != null && i < k-2; i++) {
            temp = temp.next; // Move to the node before k
        }

        if(temp == null || temp.next == null) return head; // Does kth node exist?

        temp.next = temp.next.next; // Skip the kth node

        return head; // Return the updated list
    }
}
