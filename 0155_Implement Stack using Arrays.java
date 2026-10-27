class ArrayStack {
    private int[] stackArray;
    private int capacity;
    private int topIndex;

    // Constructor: Create array → Initialize topIndex=-1
    public ArrayStack(int size){
        capacity=size;
        stackArray=new int[capacity];
        topIndex=-1;
    }

    // Push: Check full → Increment topIndex → Insert element
    public void push(int x){
        if(topIndex>=capacity-1){
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++topIndex]=x;
    }

    // Top: Check empty → Return top element
    public int top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex];
    }

    // Pop: Check empty → Return top element → Decrement topIndex
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex--];
    }

    // IsEmpty: Check topIndex==-1
    public boolean isEmpty(){
        return topIndex==-1;
    }
}
