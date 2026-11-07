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
----------------TABULATION----------------------
class Solution {
    private int func(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];

        for(int i=1;i<n;i++) {
            int pick = arr[i];

            if(i>1) {
                pick += dp[i-2];
            }

            int nonPick = dp[i-1];

            dp[i] = Math.max(pick,nonPick);
        }

        return dp[n-1];
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

        int ans1 = func(arr1);
        int ans2 = func(arr2);

        return Math.max(ans1,ans2);
    }
}
--------SPACE OPTIMIZATION--------------------------------
Additonal optimization: Instead of arr1 a nd arr2 (that takes exptra space) we can use START and END 
For first case:  start=0, end=n-2
FOr 2nd case : start=1 end =n-1

class Solution {
    private int func(int[] arr,int start,int end) {
        int prev = arr[start];
        int prev2 = 0;

        for(int i=start+1;i<=end;i++) {
            int pick = arr[i];

            if(i>start+1) {
                pick += prev2;
            }

            int nonPick = prev;
            int cur_i = Math.max(pick,nonPick);

            prev2 = prev;
            prev = cur_i;
        }

        return prev;
    }

    public int houseRobber(int[] money) {
        int n = money.length;

        if(n == 0) return 0;
        if(n == 1) return money[0];

        int ans1 = func(money,0,n-2);
        int ans2 = func(money,1,n-1);

        return Math.max(ans1,ans2);
    }
}
