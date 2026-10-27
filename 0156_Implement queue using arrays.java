class ArrayQueue {
    int[] arr;
    int start,end;
    int currSize,maxSize;

    // Constructor: Create array → Initialize pointers → Size=0
    public ArrayQueue(){
        maxSize=10;
        arr=new int[maxSize];
        start=-1;
        end=-1;
        currSize=0;
    }

    // Push: Check → Initialize/Move end → Insert → Increase size
    public void push(int x){
        if(currSize==maxSize)return;

        if(end==-1){
            start=0;
            end=0;
        }else{
            end=(end+1)%maxSize;
        }

        arr[end]=x;
        currSize++;
    }

    // Pop: Check → Read → Reset/Move start → Decrease size → Return
    public int pop(){
        if(currSize==0)return -1;

        int popped=arr[start];

        if(currSize==1){
            start=-1;
            end=-1;
        }else{
            start=(start+1)%maxSize;
        }

        currSize--;
        return popped;
    }

    // Peek: Check → Read
    public int peek(){
        if(currSize==0)return -1;
        return arr[start];
    }

    // IsEmpty: Check currSize==0
    public boolean isEmpty(){
        return currSize==0;
    }
}
