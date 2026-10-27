import java.util.*;

class QueueStack {
    Queue<Integer> q=new LinkedList<>();

    // Push: Push x at rear → Rotate previous elements from front to rear
    public void push(int x){
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            q.add(q.remove());
        }
    }

    // Pop: Check empty → Remove from front
    public int pop(){
        if(q.isEmpty())return -1;
        return q.remove();
    }

    // Top: Check empty → Read front directly
    public int top(){
        if(q.isEmpty())return -1;
        return q.peek();
    }

    // IsEmpty: Check queue empty
    public boolean isEmpty(){
        return q.isEmpty();
    }
}
