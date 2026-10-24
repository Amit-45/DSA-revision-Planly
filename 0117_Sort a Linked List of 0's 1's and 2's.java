class Solution {
    public ListNode sortList(ListNode head) {
        int count0 = 0, count1 = 0, count2 = 0;
        ListNode temp = head;

        while(temp != null) { // 1. Count 0s, 1s, 2s
            if(temp.data == 0) count0++;
            else if(temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        temp = head; // 2. Start from head again

        while(count0-- > 0) { // 3. Fill 0s
            temp.data = 0;
            temp = temp.next;
        }
        while(count1-- > 0) { // 4. Fill 1s
            temp.data = 1;
            temp = temp.next;
        }
        while(count2-- > 0) { // 5. Fill 2s
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }
}
