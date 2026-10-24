class Node {
    // Value of the node
    int data;        
    // Pointer to the next node
    Node next;      
    // Pointer to the previous node
    Node back;      

    // Constructor to initialize a node with data
    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}
