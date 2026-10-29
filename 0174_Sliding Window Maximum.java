
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] arr,int k) {
        int n=arr.length;
        int[] ans=new int[n-k+1];
        int ansIndex=0;
        Deque<Integer> dq=new LinkedList<>();

        // 1. Traverse: Process each array index
        for(int i=0;i<n;i++) {
            // 2. Remove expired indices from the front
            if(!dq.isEmpty() && dq.peekFirst()<=i-k) {
                dq.pollFirst();
            }

            // 3. Maintain decreasing order by removing smaller or equal elements
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) {
                dq.pollLast();
            }

            // 4. Add the current index
            dq.offerLast(i);

            // 5. Store the maximum once the window is complete
            if(i>=k-1) {
                ans[ansIndex++]=arr[dq.peekFirst()];
            }
        }

        // 6. Return the maximum of every window
        return ans;
    }
}
