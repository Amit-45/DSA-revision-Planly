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
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true; // 1. Handle base case

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next; // 2. Find middle
        }

        ListNode newHead = reverseList(slow.next); // 3. Reverse second half

        ListNode first = head;
        ListNode second = newHead;

        while(second != null) {
            if(first.val != second.val) { // 4. Compare both halves
                reverseList(newHead); // 5. Restore list
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseList(newHead); // 5. Restore list
        return true; // 6. All values matched
    }
}
