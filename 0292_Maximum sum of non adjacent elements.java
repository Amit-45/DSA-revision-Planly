--------------RECUR-------------------------------
f(ind) {
    if(ind == 0) return arr[0];
    if(ind < 0) return 0;

    pick = arr[ind] + f(ind-2);

    nonPick = f(ind-1);

    return Math.max(pick,nonPick);
}
-------------MEMO----------------------------------
import java.util.*;
class Solution {
    private int func(int ind,int[] arr,int[] dp) {
        if(ind == 0) return arr[0];
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = arr[ind] + func(ind-2,arr,dp);
        int nonPick = func(ind-1,arr,dp);

        return dp[ind] = Math.max(pick,nonPick);
    }

    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return func(n-1,nums,dp);
    }
}
-------------TABU--------------------------------
class Solution {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for(int i=1;i<n;i++) {
            int pick = nums[i];

            if(i>1) {
                pick += dp[i-2];
            }

            int nonPick = dp[i-1];

            dp[i] = Math.max(pick,nonPick);
        }

        return dp[n-1];
    }


}
----------SPACE OPTIMIZATIOn--------------------

class Solution {
    public int nonAdjacent(int[] nums) {
        int n = nums.length;

        int prev = nums[0];
        int prev2 = 0;

        for(int i=1;i<n;i++) {
            int pick = nums[i];

            if(i>1) {
                pick += prev2;
            }

            int nonPick = prev;

            int cur_i = Math.max(pick,nonPick);

            prev2 = prev;
            prev = cur_i;
        }

        return prev;
    }


}


