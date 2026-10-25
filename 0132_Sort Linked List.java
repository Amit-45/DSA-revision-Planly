class Solution {
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // 2. Find middle

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = (list1 != null) ? list1 : list2; // 5. Merge sorted halves
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head; // 1. Base case
        }

        ListNode middle = findMiddle(head); // 2. Find middle
        ListNode right = middle.next;
        middle.next = null; // 3. Split into halves

        ListNode left = sortList(head); // 4. Recursively sort left
        right = sortList(right); // 4. Recursively sort right

        return merge(left, right); // 6. Return merged sorted list
    }
}
