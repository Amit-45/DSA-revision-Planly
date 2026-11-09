Thought process difference:-
Coin Change I:
- I want the minimum number of coins.
- If I take a coin, I add 1 because I used one coin.
- Compare Take and Not Take using Math.min().
Coin Change II:
- I want the total number of combinations.
- If I take a coin, I don't add 1; I count the ways from the remaining target.
- Add Take and Not Take using +
--------------RECUR --------------------
class Solution {
    private int MOD=(int)1e9+7;
    private int func(int ind,int T,int[] arr) {
        if(ind==0)
            return (T%arr[0]==0) ? 1 : 0;

        int notTake=func(ind-1,T,arr);

        int take=0;
        if(arr[ind]<=T)
            take=func(ind,T-arr[ind],arr);

        return (notTake+take)%MOD;
    }
    public int change(int amount,int[] coins) {
        return func(coins.length-1,amount,coins);
    }
}
-------------MEMO-----------------------------
import java.util.*;

class Solution {
    private int MOD=(int)1e9+7;

    private int func(int[] arr,int ind,int T,long[][] dp) {
        if(ind==0)
            return (T%arr[0]==0) ? 1 : 0;

        if(dp[ind][T]!=-1)
            return (int)dp[ind][T];

        int notTaken=func(arr,ind-1,T,dp);

        int taken=0;
        if(arr[ind]<=T)
            taken=func(arr,ind,T-arr[ind],dp);

        return (int)(dp[ind][T]=(notTaken+taken)%MOD);
    }

    public int count(int[] coins,int N,int amount) {
        long[][] dp=new long[N][amount+1];

        for(long[] row:dp)
            Arrays.fill(row,-1);

        return func(coins,N-1,amount,dp);
    }
}
}
--------------------TABU-------------------------------------
class Solution {
    private int MOD=(int)1e9+7;
    public int count(int[] coins,int N,int amount) {
        long[][] dp=new long[N][amount+1];
        // Base case
        for(int target=0;target<=amount;target++) {
            if(target%coins[0]==0)
                dp[0][target]=1;
        }
        // Fill DP table
        for(int ind=1;ind<N;ind++) {
            for(int target=0;target<=amount;target++) {
                long notTaken=dp[ind-1][target];

                long taken=0;
                if(coins[ind]<=target)
                    taken=dp[ind][target-coins[ind]];

                dp[ind][target]=(notTaken+taken)%MOD;
            }
        }
        return (int)dp[N-1][amount];
    }
}
---------------------SPACE OPTI----------------------
class Solution {
    private int MOD=(int)1e9+7;
    public int count(int[] coins,int N,int amount) {
        long[] prev=new long[amount+1];
        for(int target=0;target<=amount;target++) {
            if(target%coins[0]==0)
                prev[target]=1;
        }
        for(int ind=1;ind<N;ind++) {
            long[] cur=new long[amount+1];
            for(int target=0;target<=amount;target++) {
                long notTaken=prev[target];
                long taken=0;
                if(coins[ind]<=target)
                    taken=cur[target-coins[ind]];
                cur[target]=(notTaken+taken)%MOD;
            }
            prev=cur;
        }
        return (int)prev[amount];
    }
}
