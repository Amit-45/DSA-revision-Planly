-----------------------------------------------------------
CONSTANT WINDOW 
-----------------------------------------------------------
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

--------------------------------------------------------------
