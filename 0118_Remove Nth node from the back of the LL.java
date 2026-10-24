class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null; // 1. Check empty list

        int cnt = 0;
        ListNode temp = head;
        while(temp != null) { // 2. Count total length
            cnt++;
            temp = temp.next;
        }

        if(cnt == n) return head.next; // 3. Delete head

        int res = cnt - n;
        temp = head;
        while(res > 1) { // 4. Reach node before target
            temp = temp.next;
            res--;
        }

        temp.next = temp.next.next; // 5. Skip target node
        return head;
    }
}
