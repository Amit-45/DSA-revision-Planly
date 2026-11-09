--------------------RECUR--------------------------------
class Solution {
    private int func(int ind,int n,int[] price) {
        if(ind==0)
            return price[0]*n;

        int notTake=func(ind-1,n,price);

        int rodLength=ind+1;
        int take=Integer.MIN_VALUE;

        if(rodLength<=n)
            take=price[ind]+func(ind,n-rodLength,price);

        return Math.max(notTake,take);
    }

    public int rodCutting(int[] price,int n) {
        return func(n-1,n,price);
    }
  }
}
---------------MEMO----------------------
import java.util.*;

class Solution {
    private int func(int ind,int n,int[] price,int[][] dp) {
        if(ind==0)
            return price[0]*n;

        if(dp[ind][n]!=-1)
            return dp[ind][n];

        int notTake=func(ind-1,n,price,dp);

        int rodLength=ind+1;
        int take=Integer.MIN_VALUE;

        if(rodLength<=n)
            take=price[ind]+func(ind,n-rodLength,price,dp);

        return dp[ind][n]=Math.max(notTake,take);
    }

    public int rodCutting(int[] price,int n) {
        int[][] dp=new int[n][n+1];

        for(int[] row:dp)
            Arrays.fill(row,-1);

        return func(n-1,n,price,dp);
    }
}
---------------------------TABU----------------------------
class Solution {
    public int rodCutting(int[] price,int n) {
        int[][] dp=new int[n][n+1];

        for(int length=0;length<=n;length++)
            dp[0][length]=price[0]*length;

        for(int ind=1;ind<n;ind++) {
            for(int length=0;length<=n;length++) {
                int notTake=dp[ind-1][length];

                int take=Integer.MIN_VALUE;
                int rodLength=ind+1;

                if(rodLength<=length)
                    take=price[ind]+dp[ind][length-rodLength];

                dp[ind][length]=Math.max(notTake,take);
            }
        }

        return dp[n-1][n];
    }
}
-------------SPACE OPTI---------------------------------
class Solution {
    public int rodCutting(int[] price,int n) {
        int[] dp=new int[n+1];

        for(int length=0;length<=n;length++)
            dp[length]=price[0]*length;

        for(int ind=1;ind<n;ind++) {
            int rodLength=ind+1;

            for(int length=rodLength;length<=n;length++) {
                int notTake=dp[length];
                int take=price[ind]+dp[length-rodLength];

                dp[length]=Math.max(notTake,take);
            }
        }

        return dp[n];
    }
}
