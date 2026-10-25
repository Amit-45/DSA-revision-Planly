/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/

class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        ); // 1. Create min-heap to find the smallest node

        ListNode temp = head;
        while(temp != null) {
            pq.offer(temp); // 2. Add all list heads to heap
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy; // 3. Prepare the result list

        while(!pq.isEmpty()) {
            ListNode node = pq.poll(); // 4. Remove the smallest node

            tail.child = node; // 5. Connect node to result
            tail = node; // Move tail forward

            if(node.child != null) {
                pq.offer(node.child); // 6. Insert its next child into heap
            }

            node.next = null; // 7. Remove next pointer
        }

        return dummy.child; // 8. Return flattened sorted list
    }
}
