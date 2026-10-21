import java.util.*;

class Node {
    int data;
    Node next;

    // 1. Create the Node structure
    // Store data and initialize next as null
    Node(int val) {
        data=val;
        next=null;
    }
}

public class LinkedList {

    // 4. Convert array to linked list
    public static Node arrayToLinkedList(int[] arr) {

        // Handle an empty array
        if(arr.length==0)return null;

        // 2. Create the first node and identify head
        Node head=new Node(arr[0]);
        Node current=head;

        // 3. Create and link remaining nodes
        for(int i=1;i<arr.length;i++) {
            current.next=new Node(arr[i]);
            current=current.next;
        }

        // 5. Return head to access the entire linked list
        return head;
    }

    // 6. Traverse and print until null
    public static void printLinkedList(Node head) {
        Node current=head;

        while(current!=null) {
            System.out.print(current.data+" -> ");
            current=current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Store values in an array
        int[] arr={1,2,3,4,5};

        // Create the linked list
        Node head=arrayToLinkedList(arr);

        // Print the linked list
        printLinkedList(head);
    }
}
