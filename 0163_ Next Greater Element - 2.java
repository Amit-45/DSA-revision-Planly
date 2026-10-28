Differnece from NGE : WRAP AROUND FROM LAST TO FIRST INDEX ALLOWED 
------------------------------------------------------------------
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();

        // CHANGE 1: Traverse doubled array → Handle circular nature
        for(int i=2*n-1;i>=0;i--) {

            // CHANGE 2: Get actual index using modulo
            int ind=i%n;
            int currEle=arr[ind];

            // Pop: Remove smaller or equal elements
            while(!st.isEmpty() && st.peek()<=currEle) {
                st.pop();
            }

            // CHANGE 3: Store answer only for original array
            if(i<n) {
                // NGE: If stack empty → -1, else top is NGE
                if(st.isEmpty()) ans[ind]=-1;
                else ans[ind]=st.peek();
            }

            // Push: Store current element for elements on the left
            st.push(currEle);
        }

        // Return: Next greater elements array
        return ans;
    }
}
