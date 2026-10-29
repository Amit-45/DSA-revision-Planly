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

-------------OPTIMAL-------------------------------------------------------

import java.util.*;

class MinStack {
    private Stack<Integer> st;
    private int mini;

    public MinStack() {
        st=new Stack<>();
    }

    // 1. PUSH: Store normally or encode when a new minimum arrives
    public void push(int value) {
        if(st.isEmpty()) {
            mini=value;
            st.push(value);
            return;
        }

        if(value>mini) {
            st.push(value);
        } else {
            // Encode: Store modified value instead of the new minimum
            st.push(2*value-mini);
            mini=value;
        }
    }

    // 2. POP: If encoded, restore the previous minimum
    public void pop() {
        if(st.isEmpty()) return;

        int x=st.pop();

        if(x<mini) {
            // Restore previous minimum
            mini=2*mini-x;
        }
    }

    // 3. TOP: Return actual top, decoding if necessary
    public int top() {
        if(st.isEmpty()) return -1;

        int x=st.peek();

        if(x<mini) return mini;
        return x;
    }

    // 4. GET MIN: Return the current minimum
    public int getMin() {
        if(st.isEmpty()) return -1;
        return mini;
    }
}

