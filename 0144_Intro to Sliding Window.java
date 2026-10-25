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
Ex - Longest subarray/substring where sum<=k (All array elementa are non negative)
// If solved using BRUTE: Generate all subarrays
class Solution {
    public int maxSubarrayLength(int[] arr,int k) {
        int n=arr.length,maxLen=0;

        for(int i=0;i<n;i++) {
            int sum=0;

            for(int j=i;j<n;j++) {
                sum+=arr[j]; // Extend subarray

                if(sum>k) break; // BIT OF OPTMMIZATION

                maxLen=Math.max(maxLen,j-i+1); // Update max length
            }
        }
        return maxLen;
    }
}

//BETTER SOLUTION : Sliding window : EXPAND and SHRINK
class Solution {
    public int maxSubarrayLength(int[] arr,int k) {
        int n=arr.length;
        int l=0,r=0,sum=0,maxLen=0;

        while(r<n) {
            sum+=arr[r]; // 1. Expand window

            while(sum>k) {   --------------------> Check of sum<=k -> If not VALID : SHRINK 
                sum-=arr[l]; // 2. Shrink window
                l++;
            }
        if(sum<=k) //THIS LINE YOU CAN IGNORE IF YOU WANT 
                maxLen=Math.max(maxLen,r-l+1);// 3. Update max length
            r++; // 4. Move right pointer
        }

        return maxLen;
    }
}
//OPTMIAL : Use if instead of while 
while version: Expand → Shrink until valid → Update max length.
if version: Expand → Shrink once if invalid → Update max length.


class Solution {
    public int maxSubarrayLength(int[] arr,int k) {
        int n=arr.length;
        int l=0,r=0,sum=0,maxLen=0;

        while(r<n) {
            sum+=arr[r]; // Expand

            if(sum>k) { // Shrink once if invalid
                sum-=arr[l];
                l++;
            }

            if(sum<=k)
                maxLen=Math.max(maxLen,r-l+1); // Update max length

            r++; // Move right
        }

        return maxLen;
    }
}
