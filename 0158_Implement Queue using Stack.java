//TWO STACK APPROAACH: You can optimise the PUSH OPERATION later using another method
//Remember the three points of push s1->s2, x -> s1, s2->s1
import java.util.*;
class StackQueue {
    private Stack<Integer> st1,st2;

    // Constructor: Initialize both stacks
    public StackQueue(){
        st1=new Stack<>();
        st2=new Stack<>();
    }

    // Push: st1 → st2 Then x in st1 Then st2 → st1
    public void push(int x){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        st1.push(x);

        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }

    // Pop: Check empty → Remove from st1 → Return
    public int pop(){
        if(st1.isEmpty())return -1;
        return st1.pop();
    }

    // Peek: Check empty → Read top of st1
    public int peek(){
        if(st1.isEmpty())return -1;
        return st1.peek();
    }

    // IsEmpty: Check st1 empty
    public boolean isEmpty(){
        return st1.isEmpty();
    }
}
