---------GREEDY is the optimal--------------------------------
----------RECUR-----------------------------------------------
f(ind,buy) {
    if(ind==n) return 0;

    if(buy==1) {
        take = -arr[ind] + f(ind+1,0);
        skip = f(ind+1,1);

        return Math.max(take,skip);
    }
    else {
        sell = arr[ind] + f(ind+1,1);
        skip = f(ind+1,0);

        return Math.max(sell,skip);
    }
}
--------------MEMO------------------------------------------
import java.util.*;
class Solution {
    private int func(int ind,int buy,int n,int[] arr,int[][] dp) {
        if(ind==n) return 0;

        if(dp[ind][buy]!=-1) return dp[ind][buy];

        if(buy==1) {
            int take=-arr[ind]+func(ind+1,0,n,arr,dp);
            int skip=func(ind+1,1,n,arr,dp);
            return dp[ind][buy]=Math.max(take,skip);
        }
        else {
            int sell=arr[ind]+func(ind+1,1,n,arr,dp);
            int skip=func(ind+1,0,n,arr,dp);
            return dp[ind][buy]=Math.max(sell,skip);
        }
    }

    public int stockBuySell(int[] arr,int n) {
        int[][] dp=new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);

        return func(0,1,n,arr,dp);
    }

 
}
