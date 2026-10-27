import java.util.*;

class ArrayStack {
    private int[] stackArray;
    private int capacity;
    private int topIndex;

    // Constructor: Create array → Initialize topIndex=-1
    public ArrayStack(int size) {
        capacity=size;
        stackArray=new int[capacity];
        topIndex=-1;
    }

    // Default constructor: Use capacity 1000
    public ArrayStack() {
        this(1000);
    }

    // Push: Check full → Increment → Insert
    public void push(int x) {
        if(topIndex>=capacity-1)return;
        stackArray[++topIndex]=x;
    }

    // Pop: Check empty → Read → Decrement
    public int pop() {
        if(isEmpty())return -1;
        return stackArray[topIndex--];
    }

    // Top: Check empty → Read
    public int top() {
        if(isEmpty())return -1;
        return stackArray[topIndex];
    }

    // IsEmpty: Check topIndex==-1
    public boolean isEmpty() {
        return topIndex==-1;
    }
}
