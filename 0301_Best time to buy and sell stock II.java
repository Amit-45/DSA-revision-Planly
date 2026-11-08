---------------------RECUR---------------------------------------
buy=0 → Can buy or skip.
buy=1 → Can sell or skip.
Buying → Subtract price: -arr[ind] because money goes out of our pocket.
Selling → Add price: +arr[ind] because money comes into our pocket.
ind+1 → Move to the next day after making a choice.
n → Total number of days; it does not change.
arr → Same input price array; it does not change.
Return maximum → Choose the better profit between the two choices using Math.max().
----------------------------RECUR CODE-----------------------------------------------
class Solution {
    private int func(int ind,int buy,int n,int[] arr) {
        // Base case
        if(ind==n) return 0;

        int profit=0;

        // We can buy
        if(buy==0) {
            int buyStock=-arr[ind]+func(ind+1,1,n,arr);
            int skip=func(ind+1,0,n,arr);

            profit=Math.max(buyStock,skip);
        }

        // We can sell
        else {
            int sellStock=arr[ind]+func(ind+1,0,n,arr);
            int skip=func(ind+1,1,n,arr);

            profit=Math.max(sellStock,skip);
        }

        return profit;
    }
-----------------MEMO----------------------------------
import java.util.*;

class Solution {
    private int func(int ind,int buy,int n,int[] arr,int[][] dp) {
        // Base case
        if(ind==n) return 0;

        // Check if answer is already calculated
        if(dp[ind][buy]!=-1) return dp[ind][buy];

        int profit=0;

        // We can buy
        if(buy==0) {
            int buyStock=-arr[ind]+func(ind+1,1,n,arr,dp);
            int skip=func(ind+1,0,n,arr,dp);

            profit=Math.max(buyStock,skip);
        }

        // We can sell
        else {
            int sellStock=arr[ind]+func(ind+1,0,n,arr,dp);
            int skip=func(ind+1,1,n,arr,dp);

            profit=Math.max(sellStock,skip);
        }

        // Store the answer
        return dp[ind][buy]=profit;
    }

    public int stockBuySell(int[] arr,int n) {
        int[][] dp=new int[n][2];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return func(0,0,n,arr,dp);
    }
}
    public int stockBuySell(int[] arr,int n) {
        return func(0,0,n,arr);
    }
}

--------------SPACE OPTIMISED----------------------------------------
class Solution {
    public int stockBuySell(int[] arr,int n) {
        int[] ahead=new int[2];
        int[] cur=new int[2];

        for(int ind=n-1;ind>=0;ind--) {
            cur[0]=Math.max(-arr[ind]+ahead[1],ahead[0]);

            cur[1]=Math.max(arr[ind]+ahead[0],ahead[1]);

            ahead=cur.clone();
        }

        return ahead[0];
    }
}
