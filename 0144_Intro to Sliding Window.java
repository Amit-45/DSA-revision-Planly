-----------------------------------------------------------
CONSTANT WINDOW 
-----------------------------------------------------------
Ex- Find maximum sum obtained by picking 4 elements consecutively
class Solution {
    public int maxSum(int[] arr,int k) {
        int n=arr.length;
        int l=0,r=k-1;
        int sum=0,maxSum=Integer.MIN_VALUE;

        for(int i=0;i<k;i++)
            sum+=arr[i]; // Calculate first window

        maxSum=sum;

        while(r<n-1) {
            sum-=arr[l]; // Remove outgoing element
            l++;         // Move left
            r++;         // Move right
            sum+=arr[r]; // Add incoming element
            maxSum=Math.max(maxSum,sum); // Update maximum
        }

        return maxSum;
    }
}

--------------------------------------------------------------
VARIABLE WINDOW 
--------------------------------------------------------------
Ex - Longest subarray/substring where sum<=k
// If solved using BRUTE: Generate all subarrays
class Solution {
    public int maxSubarrayLength(int[] arr,int k) {
        int n=arr.length,maxLen=0;

        for(int i=0;i<n;i++) {
            int sum=0;

            for(int j=i;j<n;j++) {
                sum+=arr[j]; // Extend subarray

                if(sum>k) break; // Stop if sum exceeds k

                maxLen=Math.max(maxLen,j-i+1); // Update max length
            }
        }
        return maxLen;
    }
}
