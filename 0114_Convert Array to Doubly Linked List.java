class Solution {
    public ListNode arrayToDoublyLinkedList(List<Integer> arr) {
        if(arr == null || arr.size() == 0) return null; // 1. Check empty array

        ListNode head = new ListNode(arr.get(0)); // 2. Create head
        ListNode prev = head;

        for(int i = 1; i < arr.size(); i++) {
            ListNode temp = new ListNode(arr.get(i), prev, null); // 3. Create node, link back
            prev.next = temp; // 4. Connect previous node forward
            prev = temp; // 5. Move prev forward
        }

        return head;
    }
}
