import java.util.*;

class Solution {
    // 1. NSE: Find the next smaller element index on the right
    private int[] findNSE(int[] arr) {
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--) {
            // Pop: Remove greater or equal elements
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            // Store NSE index; if absent, use n
            nse[i]=st.isEmpty()?n:st.peek();
            // Push: Store current index
            st.push(i);
        }
        return nse;
    }

    // 2. NGE: Find the next greater element index on the right
    private int[] findNGE(int[] arr) {
        int n=arr.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--) {
            // Pop: Remove smaller or equal elements
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]) {
                st.pop();
            }
            // Store NGE index; if absent, use n
            nge[i]=st.isEmpty()?n:st.peek();
            // Push: Store current index
            st.push(i);
        }
        return nge;
    }

    // 3. PSEE: Find the previous smaller or equal element index on the left
    private int[] findPSEE(int[] arr) {
        int n=arr.length;
        int[] psee=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++) {
            // Pop: Remove greater elements
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
                st.pop();
            }
            // Store PSEE index; if absent, use -1
            psee[i]=st.isEmpty()?-1:st.peek();
            // Push: Store current index
            st.push(i);
        }
        return psee;
    }

    // 4. PGEE: Find the previous greater or equal element index on the left
    private int[] findPGEE(int[] arr) {
        int n=arr.length;
        int[] pgee=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++) {
            // Pop: Remove smaller elements
            while(!st.isEmpty() && arr[st.peek()]<arr[i]) {
                st.pop();
            }
            // Store PGEE index; if absent, use -1
            pgee[i]=st.isEmpty()?-1:st.peek();
            // Push: Store current index
            st.push(i);
        }
        return pgee;
    }

    // 5. Sum of Subarray Minimums: Use NSE and PSEE
    private long sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse=findNSE(arr);
        int[] psee=findPSEE(arr);
        long sum=0;

        for(int i=0;i<n;i++) {
            // Count subarrays where arr[i] is the minimum
            long left=i-psee[i];
            long right=nse[i]-i;
            long freq=left*right;

            // Contribution: Element value × frequency
            sum+=(long)arr[i]*freq;
        }
        return sum;
    }

    // 6. Sum of Subarray Maximums: Use NGE and PGEE
    private long sumSubarrayMaxs(int[] arr) {
        int n=arr.length;
        int[] nge=findNGE(arr);
        int[] pgee=findPGEE(arr);
        long sum=0;

        for(int i=0;i<n;i++) {
            // Count subarrays where arr[i] is the maximum
            long left=i-pgee[i];
            long right=nge[i]-i;
            long freq=left*right;

            // Contribution: Element value × frequency
            sum+=(long)arr[i]*freq;
        }
        return sum;
    }

    // 7. Final Answer: Sum of maximums - Sum of minimums
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }
}
