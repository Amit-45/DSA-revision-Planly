import java.util.*;
class Solution {
    private int[] findNSE(int[] arr) {
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();

        // 1. NSE: Traverse right to left
        for(int i=n-1;i>=0;i--) {
            // Pop: Remove greater or equal elements
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }

            // Store next smaller element index
            nse[i]=st.isEmpty()?n:st.peek();

            // Push: Store current index
            st.push(i);
        }
        return nse;
    }

    private int[] findPSE(int[] arr) {
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();

        // 2. PSE: Traverse left to right
        for(int i=0;i<n;i++) {
            // Pop: Remove greater elements
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
                st.pop();
            }

            // Store previous smaller or equal element index
            pse[i]=st.isEmpty()?-1:st.peek();

            // Push: Store current index
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse=findNSE(arr);
        int[] pse=findPSE(arr);
        long sum=0;
        int mod=1_000_000_007;

        // 3. Count subarrays and calculate each element's contribution
        for(int i=0;i<n;i++) {
            long left=i-pse[i];
            long right=nse[i]-i;
            long freq=left*right;

            // Contribution: Element value × frequency
            sum=(sum+freq*arr[i])%mod;
        }

        // 4. Return: Sum of subarray minimums
        return (int)sum;
    }
}
