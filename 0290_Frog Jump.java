



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
