
import java.util.*;

class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        Deque<Integer> st=new ArrayDeque<>();

        // Reverse traverse: We need to know right elements first
        for(int i=n-1;i>=0;i--) {
            int currEle=arr[i];

            // Pop: Remove smaller or equal elements from stack
            while(!st.isEmpty() && st.peek()<=currEle) {
                st.pop();
            }

            // NGE: If stack empty, -1 → Else top is the next greater element
            if(st.isEmpty()) ans[i]=-1;
            else ans[i]=st.peek();

            // Push: Store current element for elements on the left
            st.push(currEle);
        }

        // Return: Next greater elements array
        return ans;
    }
}
