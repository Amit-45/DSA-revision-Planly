import java.util.*;

// 2. Create the Node structure
class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data=data;
        this.next=next;
    }
}

public class Main {
    public static void main(String[] args) {

        // 1. Store values in an ArrayList
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(8);
        arr.add(7);

        // 3. Create individual nodes
        // Each node stores data and initially points to null
        Node y1=new Node(arr.get(0),null);
        Node y2=new Node(arr.get(1),null);
        Node y3=new Node(arr.get(2),null);
        Node y4=new Node(arr.get(3),null);

        // 4. Link the nodes
        y1.next=y2;
        y2.next=y3;
        y3.next=y4;

        // 5. Identify the head (starting node)
        Node head=y1;

        // 6. Mark the end (y4.next is already null)
    }
}
