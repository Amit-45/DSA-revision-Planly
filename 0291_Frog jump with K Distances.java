------------------RECUR-------------------------------------------------------------------
class Solution {
    private int func(int ind,int[] heights,int k) {
        if(ind==0) return 0;

        int mmSteps=Integer.MAX_VALUE;

        for(int j=1;j<=k;j++) {
            if(ind-j>=0) {
                int jump=func(ind-j,heights,k)+Math.abs(heights[ind]-heights[ind-j]);

                mmSteps=Math.min(mmSteps,jump);
            }
        }

        return mmSteps;
    }

    public int frogJump(int[] heights,int k) {
        int n=heights.length;
        return func(n-1,heights,k);
    }
}
------------------MEMO----------------------------------------------------------
  import java.util.Arrays;

class Solution {
    private int func(int ind,int[] heights,int k,int[] dp) {
        if(ind==0) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int mmSteps=Integer.MAX_VALUE;

        for(int j=1;j<=k;j++) {
            if(ind-j>=0) {
                int jump=func(ind-j,heights,k,dp)+Math.abs(heights[ind]-heights[ind-j]);

                mmSteps=Math.min(mmSteps,jump);
            }
        }

        return dp[ind]=mmSteps;
    }

    public int frogJump(int[] heights,int k) {
        int n=heights.length;

        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        return func(n-1,heights,k,dp);
    }
}
-----------------TABUL----------------------------------------
CREATE DP[N] → DP[0]=0 → LOOP I=1 TO N-1 → INITIALIZE MAX → LOOP J=1 TO K → CHECK VALID INDEX → CALCULATE ENERGY → TAKE MINIMUM → STORE DP[I] → RETURN DP[N-1]
--------------------------------------------------------------
class Solution {
    public int frogJump(int[] heights,int k) {
        int n=heights.length;

        int[] dp=new int[n];
        dp[0]=0;

        for(int i=1;i<n;i++) {
            int mmSteps=Integer.MAX_VALUE;

            for(int j=1;j<=k;j++) {
                if(i-j>=0) {
                    int jump=dp[i-j]+Math.abs(heights[i]-heights[i-j]);

                    mmSteps=Math.min(mmSteps,jump);
                }
            }

            dp[i]=mmSteps;
        }

        return dp[n-1];
    }
}
-------------SPACE OPTIMIZATION-----------------------------------------------------
class Solution {
    public int frogJump(int[] heights,int k) {
        int n=heights.length;

        int[] dp=new int[k];

        for(int i=1;i<n;i++) {
            int mmSteps=Integer.MAX_VALUE;

            for(int j=1;j<=k;j++) {
                if(i-j>=0) {
                    int prevIndex=(i-j)%k;

                    int jump=dp[prevIndex]+Math.abs(heights[i]-heights[i-j]);

                    mmSteps=Math.min(mmSteps,jump);
                }
            }

            dp[i%k]=mmSteps;
        }

        return dp[(n-1)%k];
    }
}
