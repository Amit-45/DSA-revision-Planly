----------RECUR-----------------------------------------------
f(ind) {
    oneStep = f(ind-1) + Math.abs(heights[ind]-heights[ind-1]);

    twoStep = Integer.MAX_VALUE;
    if(ind>1) {
        twoStep = f(ind-2) + Math.abs(heights[ind]-heights[ind-2]);
    }

    return Math.min(oneStep,twoStep);
}
----------MEMO----------------------------------
CREATE DP[N] → FILL -1 → BASE CASE → CHECK DP → TRY BOTH JUMPS → TAKE MINIMUM → STORE → RETURN
-------------------------------------------------
import java.util.Arrays;
class Solution {
    private int solve(int ind,int[] heights,int[] dp) {
        if(ind==0) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int jumpOne=solve(ind-1,heights,dp)+Math.abs(heights[ind]-heights[ind-1]);

        int jumpTwo=Integer.MAX_VALUE;
        if(ind>1) {
            jumpTwo=solve(ind-2,heights,dp)+Math.abs(heights[ind]-heights[ind-2]);
        }

        return dp[ind]=Math.min(jumpOne,jumpTwo);
    }

    public int frogJump(int[] heights) {
        int n=heights.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        return solve(n-1,heights,dp);
    }
}
------------TABU---------------------------------------------------
CREATE DP[N] → DP[0]=0 → LOOP I=1 TO N-1 → CALCULATE 1-STEP → CALCULATE 2-STEP → TAKE MINIMUM → RETURN DP[N-1]
-------------------------------------------------------------------
class Solution {
    public int frogJump(int[] heights) {
        int n=heights.length;
        int[] dp=new int[n];

        dp[0]=0;

        for(int i=1;i<n;i++) {
            int jumpOne=dp[i-1]+Math.abs(heights[i]-heights[i-1]);

            int jumpTwo=Integer.MAX_VALUE;
            if(i>1) {
                jumpTwo=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
            }

            dp[i]=Math.min(jumpOne,jumpTwo);
        }

        return dp[n-1];
    }
}
--------------------------SPACE OPTIMIZATION-----------------------------------------
INITIALIZE PREV2 & PREV → LOOP I=1 TO N-1 → CALCULATE JUMP ONE → CALCULATE JUMP TWO → TAKE MINIMUM → SHIFT VARIABLES → RETURN PREV
--------------------------------------------------------------------------------------
class Solution {
    public int frogJump(int[] heights) {
        int n=heights.length;

        int prev=0;
        int prev2=0;

        for(int i=1;i<n;i++) {
            int jumpOne=prev+Math.abs(heights[i]-heights[i-1]);

            int jumpTwo=Integer.MAX_VALUE;
            if(i>1) {
                jumpTwo=prev2+Math.abs(heights[i]-heights[i-2]);
            }

            int cur_i=Math.min(jumpOne,jumpTwo);

            prev2=prev;
            prev=cur_i;
        }

        return prev;
    }
}
--------------------------------------------------------------------------------------
