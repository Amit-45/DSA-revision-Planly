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







     --------------------------------------------
    //RECURSIVE SOLUTION:
    class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head; // 1. Stop at last node

        ListNode newHead = reverseList(head.next); // 2. Call next node

        ListNode front = head.next; // 3. Get next node
        front.next = head; // 4. Reverse link
        head.next = null; // 5. Break old link

        return newHead; // 6. Return new head
    }
}
