class Node {
    int val;
    Node next;

    Node(int d){
        val=d;
        next=null;
    }
}

class LinkedListStack {
    private Node head;
    private int size;

    // Initialize: Top is empty → Size is zero
    public LinkedListStack(){
        head=null;
        size=0;
    }

    // Push: Create node → Point new node to old top → Move top to new node
    public void push(int x){
        Node node=new Node(x);
        node.next=head;
        head=node;
        size++;
    }

    // Pop: Check empty → Read top value → Move top to next node → Decrease size
    public int pop(){
        if(head==null)return -1;
        int value=head.val;
        head=head.next;
        size--;
        return value;
    }

    // Top: Check empty → Read top value
    public int top(){
        if(head==null)return -1;
        return head.val;
    }

    // IsEmpty: Check if size is zero
    public boolean isEmpty(){
        return size==0;
    }
}
