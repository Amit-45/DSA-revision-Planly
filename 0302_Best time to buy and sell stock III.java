-----------------Recur-----------------------------
f(ind, buy, cap) {
    if(ind == n || cap == 0) return 0;

    if(buy == 0) {
        op1 = 0 + f(ind+1, 0, cap);
        op2 = -arr[ind] + f(ind+1, 1, cap);
    }

    if(buy == 1) {
        op1 = 0 + f(ind+1, 1, cap);
        op2 = arr[ind] + f(ind+1, 0, cap-1);
    }

    return Math.max(op1, op2);
}
--------Memo------------------------------------
import java.util.*;
class Solution {
    private int func(int ind, int buy, int cap, int n, int[] arr, int[][][] dp) {
        if(ind == n || cap == 0) return 0;

        if(dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }

        int profit = 0;

        if(buy == 0) {
            int op1 = func(ind+1, 0, cap, n, arr, dp);
            int op2 = -arr[ind] + func(ind+1, 1, cap, n, arr, dp);
            profit = Math.max(op1, op2);
        }

        if(buy == 1) {
            int op1 = func(ind+1, 1, cap, n, arr, dp);
            int op2 = arr[ind] + func(ind+1, 0, cap-1, n, arr, dp);
            profit = Math.max(op1, op2);
        }

        return dp[ind][buy][cap] = profit;
    }

}
-------Tabul-----------------------------------------

class Solution {
    public int stockBuySell(int[] arr, int n) {
        int[][][] dp = new int[n+1][2][3];

        for(int ind=n-1; ind>=0; ind--) {
            for(int buy=0; buy<=1; buy++) {
                for(int cap=1; cap<=2; cap++) {

                    if(buy == 0) {
                        dp[ind][buy][cap] = Math.max(
                            dp[ind+1][0][cap],
                            -arr[ind] + dp[ind+1][1][cap]
                        );
                    }

                    if(buy == 1) {
                        dp[ind][buy][cap] = Math.max(
                            dp[ind+1][1][cap],
                            arr[ind] + dp[ind+1][0][cap-1]
                        );
                    }
                }
            }
        }

        return dp[0][0][2];
    }
}
-------------Space Optimi----------------------------

class Solution {
    public int stockBuySell(int[] arr, int n) {
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

        for(int ind=n-1; ind>=0; ind--) {
            for(int buy=0; buy<=1; buy++) {
                for(int cap=1; cap<=2; cap++) {

                    if(buy == 0) {
                        cur[buy][cap] = Math.max(
                            ahead[0][cap],
                            -arr[ind] + ahead[1][cap]
                        );
                    }

                    if(buy == 1) {
                        cur[buy][cap] = Math.max(
                            ahead[1][cap],
                            arr[ind] + ahead[0][cap-1]
                        );
                    }
                }
            }

            int[][] temp = ahead;
            ahead = cur;
            cur = temp;
        }

        return ahead[0][2];
    }
}

