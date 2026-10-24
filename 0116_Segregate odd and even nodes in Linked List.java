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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head; // 1. Check edge cases

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // 2. Initialize pointers and save even head

        while(even != null && even.next != null) {
            odd.next = even.next; // 3. Connect odd nodes
            odd = odd.next;

            even.next = odd.next; // 4. Connect even nodes
            even = even.next;
        }

        odd.next = evenHead; // 5. Join odd and even lists
        return head;
    }
}
