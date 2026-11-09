

---------------MEMO------------------------------------
import java.util.*;

class Solution {
    private int func(int[] wt,int[] val,int ind,int W,int[][] dp) {
        if(ind<0 || W==0) {
            return 0;
        }

        if(dp[ind][W]!=-1) {
            return dp[ind][W];
        }

        int notTaken=func(wt,val,ind-1,W,dp);
        int taken=0;

        if(wt[ind]<=W) {
            taken=val[ind]+func(wt,val,ind-1,W-wt[ind],dp);
        }

        return dp[ind][W]=Math.max(notTaken,taken);
    }

    public int knapsack01(int[] wt,int[] val,int n,int W) {
        int[][] dp=new int[n][W+1];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return func(wt,val,n-1,W,dp);
    }
}
---------------------TABU------------------------------------
class Solution {
    public int knapsack01(int[] wt,int[] val,int n,int W) {
        int[][] dp=new int[n][W+1];

        for(int cap=wt[0];cap<=W;cap++) {
            dp[0][cap]=val[0];
        }

        for(int ind=1;ind<n;ind++) {
            for(int cap=0;cap<=W;cap++) {
                int notTaken=dp[ind-1][cap];

                int taken=Integer.MIN_VALUE;

                if(wt[ind]<=cap) {
                    taken=val[ind]+dp[ind-1][cap-wt[ind]];
                }

                dp[ind][cap]=Math.max(notTaken,taken);
            }
        }

        return dp[n-1][W];
    }
}
----------------SPACE OPTI -----------------------------------
  class Solution {
    public int knapsack01(int[] wt,int[] val,int n,int W) {
        int[] prev=new int[W+1];

        for(int cap=wt[0];cap<=W;cap++) {
            prev[cap]=val[0];
        }

        for(int ind=1;ind<n;ind++) {
            for(int cap=W;cap>=0;cap--) {
                int notTaken=prev[cap];
                int taken=Integer.MIN_VALUE;

                if(wt[ind]<=cap) {
                    taken=val[ind]+prev[cap-wt[ind]];
                }

                prev[cap]=Math.max(notTaken,taken);
            }
        }

        return prev[W];
    }
}
  
