class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy; // 1. Create dummy and temp

        while(list1 != null && list2 != null) { // 2. Compare both list nodes
            if(list1.val <= list2.val) {
                temp.next = list1; // 3. Connect smaller node
                list1 = list1.next; // Move list1
            } else {
                temp.next = list2; // 3. Connect smaller node
                list2 = list2.next; // Move list2
            }
            temp = temp.next; // 4. Move temp forward and repeat
        }

        temp.next = (list1 != null) ? list1 : list2; // 5. Attach remaining nodes
        return dummy.next; // 6. Return merged list
    }
}
