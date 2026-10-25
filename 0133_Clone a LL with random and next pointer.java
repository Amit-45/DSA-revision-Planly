class Solution {
    void insertCopyInBetween(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            ListNode nextElement = temp.next;
            ListNode copy = new ListNode(temp.val); // 1. Create copy
            copy.next = nextElement;
            temp.next = copy; // Insert copy after original
            temp = nextElement;
        }
    }

    void connectRandomPointers(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            ListNode copyNode = temp.next;
            if(temp.random != null) {
                copyNode.random = temp.random.next; // 2. Connect copied random
            }
            temp = temp.next.next; // Move to next original
        }
    }

    ListNode getDeepCopyList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        ListNode temp = head;

        while(temp != null) {
            res.next = temp.next; // 3. Extract copied node
            res = res.next;
            temp.next = temp.next.next; // Restore original list
            temp = temp.next;
        }
        return dummy.next; // Return copied list
    }

    public ListNode copyRandomList(ListNode head) {
        if(head == null) return null;

        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }
}
