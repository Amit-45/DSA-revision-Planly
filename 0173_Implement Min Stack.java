----------------------------BRUTE (using  Pair)-------------------------------------------------------------
import java.util.*;
class MinStack {
    private Stack<int[]> st;
    public MinStack() {
        st=new Stack<>();
    }
    // 1. PUSH: Store {element, current minimum}
    public void push(int value) {
        if(st.isEmpty()) {
            st.push(new int[]{value,value});
            return;
        }
        // Find the minimum so far
        int mini=Math.min(getMin(),value);
        // Push the element along with its minimum
        st.push(new int[]{value,mini});
    }
    // 2. POP: Remove the top pair
    public void pop() {
        st.pop();
    }
    // 3. TOP: Return the element (first value)
    public int top() {
        return st.peek()[0];
    }
    // 4. GET MIN: Return the minimum (second value)
    public int getMin() {
        return st.peek()[1];
    }
}
