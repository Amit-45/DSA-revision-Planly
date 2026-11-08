---------GREEDY is the optimal--------------------------------
class Solution {
    public int stockBuySell(int[] arr,int n) {
        int maxProfit=0; // Stores maximum profit
        int mini=arr[0]; // Stores minimum buying price so far
        // Traverse the array from the second day
        for(int i=1;i<n;i++) {
            // Calculate profit if we sell the stock today
            int curProfit=arr[i]-mini;
            // Update maximum profit
            maxProfit=Math.max(maxProfit,curProfit);
            // Update minimum buying price for future days
            mini=Math.min(mini,arr[i]);
        }
        // Return the maximum profit
        return maxProfit;
    }
}
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
