-------------------RECUR----------------------------------

class Solution {
    private int func(int[] wt,int[] val,int ind,int W) {
        if(ind==0)
            return (W/wt[0])*val[0];

        int notTake=func(wt,val,ind-1,W);

        int take=Integer.MIN_VALUE;
        if(wt[ind]<=W)
            take=val[ind]+func(wt,val,ind,W-wt[ind]);

        return Math.max(notTake,take);
    }

    public int unboundedKnapsack(int[] wt,int[] val,int n,int W) {
        return func(wt,val,n-1,W);
    }
}

--------------------MEMO----------------------------------
import java.util.*;
class Solution {
    private int func(int[] wt,int[] val,int ind,int W,int[][] dp) {
        if(ind==0)
            return (W/wt[0])*val[0];

        if(dp[ind][W]!=-1)
            return dp[ind][W];

        int notTake=func(wt,val,ind-1,W,dp);

        int take=Integer.MIN_VALUE;
        if(wt[ind]<=W)
            take=val[ind]+func(wt,val,ind,W-wt[ind],dp);

        return dp[ind][W]=Math.max(notTake,take);
    }

    public int unboundedKnapsack(int[] wt,int[] val,int n,int W) {
        int[][] dp=new int[n][W+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return func(wt,val,n-1,W,dp);
    }
}
------------------TABU------------------------------
class Solution {
    public int unboundedKnapsack(int[] wt,int[] val,int n,int W) {
        int[][] dp=new int[n][W+1];

        for(int cap=0;cap<=W;cap++)
            dp[0][cap]=(cap/wt[0])*val[0];

        for(int ind=1;ind<n;ind++) {
            for(int cap=0;cap<=W;cap++) {
                int notTake=dp[ind-1][cap];

                int take=Integer.MIN_VALUE;
                if(wt[ind]<=cap)
                    take=val[ind]+dp[ind][cap-wt[ind]];

                dp[ind][cap]=Math.max(notTake,take);
            }
        }

        return dp[n-1][W];
    }
}
------------SPACE OPTI------------------------------
class Solution {
    public int unboundedKnapsack(int[] wt,int[] val,int n,int W) {
        int[] prev=new int[W+1];
        int[] cur=new int[W+1];

        for(int cap=0;cap<=W;cap++)
            prev[cap]=(cap/wt[0])*val[0];

        for(int ind=1;ind<n;ind++) {
            for(int cap=0;cap<=W;cap++) {
                int notTake=prev[cap];

                int take=Integer.MIN_VALUE;
                if(wt[ind]<=cap)
                    take=val[ind]+cur[cap-wt[ind]];

                cur[cap]=Math.max(notTake,take);
            }
            prev=cur;
        }

        return prev[W];
    }
}
