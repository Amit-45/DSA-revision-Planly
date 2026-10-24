class Solution {
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        if(head == null) { // 1. Check empty list
            if(K == 1) return new ListNode(X);
            return head;
        }

        if(K == 1) return new ListNode(X, head); // 2. Insert at head

        ListNode temp = head;
        int cnt = 0;

        while(temp != null) {
            cnt++; // 3. Count current node

            if(cnt == K-1) { // 4. Find node before K
                ListNode newNode = new ListNode(X, temp.next); // 5. Link new node to next
                temp.next = newNode; // 6. Link previous node to new node
                break;
            }

            temp = temp.next; // 7. Move forward
        }

        return head; // 8. Return updated list
    }
}
