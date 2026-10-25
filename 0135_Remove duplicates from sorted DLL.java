class Solution {
    public ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp != null && temp.next != null) {
            // 1. Traverse and compare adjacent nodes
            if(temp.val == temp.next.val) {
                ListNode nextNode = temp.next;

                // 2. Skip all duplicate nodes
                while(nextNode != null && nextNode.val == temp.val) {
                    nextNode = nextNode.next;
                }

                // 3. Connect to the next unique node
                temp.next = nextNode;

                // 4. Fix prev link
                if(nextNode != null) {
                    nextNode.prev = temp;
                }
            } else {
                temp = temp.next; // 5. Move forward
            }
        }

        return head; // 6. Return head
    }
}
