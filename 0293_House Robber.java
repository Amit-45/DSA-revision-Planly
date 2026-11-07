----------------RECUR----------------------------
f(ind,arr) {
    if(ind == 0) return arr[0];
    if(ind < 0) return 0;

    pick = arr[ind] + f(ind-2,arr);

    nonPick = f(ind-1,arr);

    return Math.max(pick,nonPick);
}

arr1 = money[0...n-2];
arr2 = money[1...n-1];

ans1 = f(n-2,arr1);
ans2 = f(n-2,arr2);

return Math.max(ans1,ans2);
----------------MEMO-----------------------------
2 DP arrays
-------------------------------------------
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

    public int houseRobber(int[] money) {
        int n = money.length;

        if(n == 0) return 0;
        if(n == 1) return money[0];

        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];

        for(int i=0;i<n-1;i++) {
            arr1[i] = money[i];
            arr2[i] = money[i+1];
        }

        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int ans1 = func(n-2,arr1,dp1);
        int ans2 = func(n-2,arr2,dp2);

        return Math.max(ans1,ans2);
    }
}
