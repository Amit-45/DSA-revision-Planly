---------------RECUR: PARTITION DP-----------------------------
class Solution {
    private int func(int[] nums,int i,int j) {
        if(i==j)
            return 0; // Single matrix

        int mini=Integer.MAX_VALUE;

        for(int k=i;k<j;k++) { // Try partitions
            int cost=func(nums,i,k)+func(nums,k+1,j)
                     +nums[i-1]*nums[k]*nums[j]; // Left + Right + Multiply

            mini=Math.min(mini,cost); // Minimum cost
        }

        return mini;
    }

    public int matrixMultiplication(int[] nums) {
        return func(nums,1,nums.length-1);
    }
}
------------MEMO---------------------------------
import java.util.*;

class Solution {
    private int func(int[] nums,int i,int j,int[][] dp) {
        if(i==j)
            return 0; // Single matrix

        if(dp[i][j]!=-1)
            return dp[i][j]; // Already computed

        int mini=Integer.MAX_VALUE;

        for(int k=i;k<j;k++) {
            int cost=func(nums,i,k,dp)+func(nums,k+1,j,dp)
                     +nums[i-1]*nums[k]*nums[j];

            mini=Math.min(mini,cost); // Minimum cost
        }

        return dp[i][j]=mini; // Store result
    }

    public int matrixMultiplication(int[] nums) {
        int n=nums.length;

        int[][] dp=new int[n][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        return func(nums,1,n-1,dp);
    }
}
-----------------TABU-----------------------------------
class Solution {
    public int matrixMultiplication(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n];

        for(int i=n-1;i>=1;i--) {
            for(int j=i+1;j<n;j++) {
                int mini=Integer.MAX_VALUE;

                for(int k=i;k<j;k++) {
                    int cost=dp[i][k]+dp[k+1][j]
                             +nums[i-1]*nums[k]*nums[j];

                    mini=Math.min(mini,cost);
                }

                dp[i][j]=mini;
            }
        }

        return dp[1][n-1];
    }
}
--------------SPACE OPTI=NOT POSSIBLE----------------------
