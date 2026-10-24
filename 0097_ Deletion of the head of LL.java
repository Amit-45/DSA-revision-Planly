//FULL CODE :

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int data) {
        val = data; // 1. Store node value
        next = null; // 2. Initialize next pointer
    }
}
// -----------------------------------------------------------------------
// MAIN LOGIC
//------------------------------------------------------------------------
class Solution {
    public ListNode deleteHead(ListNode head) {
        if(head == null) return null; // 3. If empty, return null
        head = head.next; // 4. Move head to the next node
        return head; // 5. Return new head
    }
}
// -----------------------------------------------------------------------------
class Main {
    public static void printList(ListNode head) {
        while(head != null) { // 6. Traverse until the end
            System.out.print(head.val + " "); // 7. Print node value
            head = head.next; // 8. Move to next node
        }
        System.out.println();
    }

    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data); // 9. Create new node
        newNode.next = head; // 10. Link to current head
        return newNode; // 11. Return new head
    }

    public static void main(String[] args) {
        ListNode head = null; // 12. Start with empty list

        head = insertAtHead(head, 3); // 13. List: 3
        head = insertAtHead(head, 2); // 14. List: 2 -> 3
        head = insertAtHead(head, 1); // 15. List: 1 -> 2 -> 3

        System.out.print("Original list: ");
        printList(head); // 16. Print original list

        Solution sol = new Solution(); // 17. Create Solution object
        head = sol.deleteHead(head); // 18. Delete head and update head

        System.out.print("After deleting head: ");
        printList(head); // 19. Print updated list
    }
}
