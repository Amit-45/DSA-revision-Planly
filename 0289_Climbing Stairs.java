-----------------------------RECUR-------------------------------
f(n){
      oneStep = f(n-1)
      twoStep = f(n-2)
      return oneStep + twoStep
}
---------MEMO = RECURSION + DP ARRAY--------------------------------
CREATE DP → FILL -1 → BASE CASE → CHECK STORED → RECURSIVE CALLS → STORE ANSWER → RETURN
--------------------------------------------------------------------
import java.util.*;
class Solution {
    private int func(int n,int[] dp) {
        if(n<=1) return 1;

        if(dp[n]!=-1) return dp[n];

        return dp[n]=func(n-1,dp)+func(n-2,dp);
    }

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return func(n,dp);
    }
}
-------TABULATION = ITERATION + DP ARRAY--------------------------------
HANDLE SMALL N → CREATE DP → SET BASE CASES → LOOP 2 TO N → ADD PREVIOUS TWO → RETURN DP[N]
-------------------------------------------------------------------------
class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;

        int[] dp=new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
------
