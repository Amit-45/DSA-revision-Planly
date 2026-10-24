class Solution {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        if(head == null) return null; // 1. Check empty list

        if(head.data == X) 
            return new ListNode(val, head); // 2. Insert before head

        ListNode temp = head; // 3. Start from head

        while(temp.next != null) {
            if(temp.next.data == X) { // 4. Find target using next node
                ListNode newNode = new ListNode(val, temp.next); // 5. Connect new node to target
                temp.next = newNode; // 6. Connect previous node to new node
                break;
            }

            temp = temp.next; // 7. Move forward
        }

        return head; // 8. Return updated list
    }
}
