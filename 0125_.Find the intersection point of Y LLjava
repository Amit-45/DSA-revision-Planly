/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null; // 1. Handle empty lists

        ListNode d1 = headA;
        ListNode d2 = headB; // 2. Start at both heads

        while(d1 != d2) {
            d1 = (d1 == null) ? headB : d1.next; // 3. Move or switch to B
            d2 = (d2 == null) ? headA : d2.next; // 4. Move or switch to A
        }

        return d1; // 5. Return intersection or null
    }
}
