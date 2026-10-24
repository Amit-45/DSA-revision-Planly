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
    public ListNode findStartingPoint(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // 1. Slow +1
            fast = fast.next.next; // 2. Fast +2

            if(slow == fast) {
                slow = head; // 3. Reset slow

                while(slow != fast) {
                    slow = slow.next; // 4. Move both +1
                    fast = fast.next;
                }

                return slow; // 5. Return loop start
            }
        }

        return null; // No loop
    }
}
