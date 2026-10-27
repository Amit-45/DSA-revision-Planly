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
--------------------------------------------------------------------------------
OPTIMAL CODE APPROACH : Put all elements from s1 to s2 after all push approach
--------------------------------------------------------------------------------
import java.util.*;

class StackQueue {
    private Stack<Integer> input,output;

    // Constructor: Initialize s1 and s2
    public StackQueue(){
        input=new Stack<>();
        output=new Stack<>();
    }

    // Push: x → s1
    public void push(int x){
        input.push(x);
    }

    // Pop: If s2 not empty → Pop s2; else → Transfer s1 → s2 → Pop s2
    public int pop(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        if(output.isEmpty())return -1;
        return output.pop();
    }

    // Peek: If s2 not empty → Read s2; else → Transfer s1 → s2 → Read s2
    public int peek(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        if(output.isEmpty())return -1;
        return output.peek();
    }

    // IsEmpty: Check s1 empty AND s2 empty
    public boolean isEmpty(){
        return input.isEmpty()&&output.isEmpty();
    }
}
