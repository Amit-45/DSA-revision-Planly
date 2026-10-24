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
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
        if(K == 1) { // 1. Insert before head
            ListNode newHead = new ListNode(X, null, head);
            head.prev = newHead;
            return newHead;
        }

        ListNode temp = head;
        int count = 0;
        while(temp != null) { // 2. Find Kth node
            count++;
            if(count == K) break;
            temp = temp.next;
        }

        ListNode prev = temp.prev; // 3. Remember previous node
        ListNode newNode = new ListNode(X, prev, temp); // 4. Create and connect node
        prev.next = newNode;
        temp.prev = newNode;

        return head; // 5. Return head
    }
}
