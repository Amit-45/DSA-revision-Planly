class Solution {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;

        while(temp != null) {
            if(temp.val == target) { // 1. Match target
                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                if(temp == head) head = nextNode; // 2. Update head
                if(prevNode != null) prevNode.next = nextNode;
                if(nextNode != null) nextNode.prev = prevNode; // 3. Update links

                temp = nextNode; // 4. Move next
            } else {
                temp = temp.next;
            }
        }

        return head; // 5. Return head
    }
}
