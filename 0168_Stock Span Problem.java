import java.util.*;

class Solution {
    public static int[] calculateSpan(int[] arr) {
        int n=arr.length;
        int[] span=new int[n];
        Stack<Integer> st=new Stack<>();

        // 1. Traverse: Go left to right
        for(int i=0;i<n;i++) {

            // 2. Pop: Remove smaller or equal prices
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]) {
                st.pop();
            }

            // 3. Calculate Span: Find previous greater element
            span[i]=st.isEmpty()?i+1:i-st.peek();

            // 4. Push: Store current index
            st.push(i);
        }

        // 5. Return: Stock span of each day
        return span;
    }
}
