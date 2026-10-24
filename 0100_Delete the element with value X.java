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
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        if(head == null) return head; // 1. Check empty list

        if(head.data == X) return head.next; // 2. Delete head if target

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            if(temp.data == X) { // 3. Find target using temp
                prev.next = temp.next; // 4. Skip target node
                return head;
            }

            prev = temp; // 5. Remember previous node
            temp = temp.next; // 6. Move temp forward
        }

        return head; // 7. Target not found, return unchanged list
    }
}
