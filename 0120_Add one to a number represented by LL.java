//ITERATIVE SOLUTION 
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode addOne(ListNode head) {
        head = reverseList(head); // 1. Reverse the list

        ListNode temp = head;
        int carry = 1; // 2. Initialize carry

        while(temp != null) {
            int sum = temp.val + carry; // 3. Add carry
            temp.val = sum % 10;
            carry = sum / 10;

            if(carry == 0) break;

            if(temp.next == null) {
                temp.next = new ListNode(carry); // 4. Handle remaining carry
                carry = 0;
                break;
            }

            temp = temp.next;
        }

        head = reverseList(head); // 5. Reverse back
        return head;
    }
}
