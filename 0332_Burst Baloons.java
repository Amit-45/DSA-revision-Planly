----------------RECUR--------------------------
class Solution {
    private int func(int i,int j,int[] nums) {
        if(i>j)
            return 0; // No balloons left

        int maxCoins=Integer.MIN_VALUE;

        for(int k=i;k<=j;k++) { // Try every balloon as LAST
            int coins=nums[i-1]*nums[k]*nums[j+1]; // Calculate current coins

            int remainingCoins=func(i,k-1,nums)+func(k+1,j,nums)+coins; // Combine left + right + current coins

            maxCoins=Math.max(maxCoins,remainingCoins); // Take maximum
        }

        return maxCoins;
    }

    public int maxCoins(int[] nums) {
        int n=nums.length;

        int[] newNums=new int[n+2]; // Add 1 at both ends
        newNums[0]=1;
        newNums[n+1]=1;
        System.arraycopy(nums,0,newNums,1,n);

        return func(1,n,newNums); // Start with entire range
    }
}
----------------MEMO----------------------------
import java.util.*;

class Solution {
    private int func(int i,int j,int[] nums,int[][] dp) {
        if(i>j)
            return 0; // No balloons left

        if(dp[i][j]!=-1)
            return dp[i][j]; // Already calculated

        int maxCoins=Integer.MIN_VALUE;

        for(int k=i;k<=j;k++) {
            int coins=nums[i-1]*nums[k]*nums[j+1];

            int remainingCoins=func(i,k-1,nums,dp)+func(k+1,j,nums,dp);

            maxCoins=Math.max(maxCoins,coins+remainingCoins);
        }

        return dp[i][j]=maxCoins; // Store answer
    }

    public int maxCoins(int[] nums) {
        int n=nums.length;

        int[] newNums=new int[n+2];
        newNums[0]=1;
        newNums[n+1]=1;
        System.arraycopy(nums,0,newNums,1,n);

        int[][] dp=new int[n+2][n+2];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        return func(1,n,newNums,dp);
    }
}
------------------TABU-------------------------------
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;

        int[] newNums=new int[n+2];
        newNums[0]=1;
        newNums[n+1]=1;
        System.arraycopy(nums,0,newNums,1,n);

        int[][] dp=new int[n+2][n+2];

        for(int i=n;i>=1;i--) {
            for(int j=1;j<=n;j++) {
                if(i>j)
                    continue;

                int maxCoins=Integer.MIN_VALUE;

                for(int k=i;k<=j;k++) {
                    int coins=newNums[i-1]*newNums[k]*newNums[j+1];

                    int remainingCoins=dp[i][k-1]+dp[k+1][j];

                    maxCoins=Math.max(maxCoins,coins+remainingCoins);
                }

                dp[i][j]=maxCoins;
            }
        }

        return dp[1][n];
    }
}
