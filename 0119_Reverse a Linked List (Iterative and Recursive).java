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
    //ITERATIVE
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            ListNode front = temp.next; // 1. Save front
            temp.next = prev; // 2. Reverse link
            prev = temp; // 3. Move prev
            temp = front; // 4. Move temp
        }

        return prev; // 5. Return new head
    }
}
