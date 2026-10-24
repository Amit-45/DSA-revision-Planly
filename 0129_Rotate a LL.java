class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head; // 1. Handle edge cases

        ListNode temp = head;
        int length = 1;

        while(temp.next != null) {
            length++; // 2. Count nodes
            temp = temp.next;
        }

        k = k % length; // 3. Reduce rotations
        if(k == 0) return head;

        temp.next = head; // 4. Make circular list

        int steps = length - k;
        while(steps-- > 0) {
            temp = temp.next; // 5. Find new tail
        }

        head = temp.next; // 6. Set new head
        temp.next = null; // 7. Break circle

        return head; // 8. Return rotated list
    }
}
