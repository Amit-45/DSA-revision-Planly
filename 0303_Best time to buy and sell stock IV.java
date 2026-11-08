---------Recur---------------------
class Solution {
    private int func(int ind,int buy,int cap,int[] arr,int n) {
        if(ind == n || cap == 0) return 0;

        int profit;

        if(buy == 0) {
            int op1 = func(ind+1,0,cap,arr,n);
            int op2 = -arr[ind]+func(ind+1,1,cap,arr,n);
            profit = Math.max(op1,op2);
        } else {
            int op1 = func(ind+1,1,cap,arr,n);
            int op2 = arr[ind]+func(ind+1,0,cap-1,arr,n);
            profit = Math.max(op1,op2);
        }

        return profit;
    }

    public int stockBuySell(int[] arr,int n,int k) {
        return func(0,0,k,arr,n);
    }
}
------------Memo-------------------
import java.util.*;

class Solution {
    private int func(int ind,int buy,int cap,int[] arr,int n,int[][][] dp) {
        if(ind == n || cap == 0) return 0;

        if(dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }

        int profit;

        if(buy == 0) {
            int op1 = func(ind+1,0,cap,arr,n,dp);
            int op2 = -arr[ind]+func(ind+1,1,cap,arr,n,dp);
            profit = Math.max(op1,op2);
        } else {
            int op1 = func(ind+1,1,cap,arr,n,dp);
            int op2 = arr[ind]+func(ind+1,0,cap-1,arr,n,dp);
            profit = Math.max(op1,op2);
        }

        return dp[ind][buy][cap] = profit;
    }

    public int stockBuySell(int[] arr,int n,int k) {
        int[][][] dp = new int[n][2][k+1];

        for(int i=0;i<n;i++) {
            for(int j=0;j<2;j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }

        return func(0,0,k,arr,n,dp);
    }
}
-----------Tabu----------------------
class Solution {
    public int stockBuySell(int[] arr,int n,int k) {
        int[][][] dp = new int[n+1][2][k+1];

        for(int ind=n-1;ind>=0;ind--) {
            for(int buy=0;buy<=1;buy++) {
                for(int cap=1;cap<=k;cap++) {
                    if(buy == 0) {
                        dp[ind][0][cap] = Math.max(
                            dp[ind+1][0][cap],
                            -arr[ind]+dp[ind+1][1][cap]
                        );
                    } else {
                        dp[ind][1][cap] = Math.max(
                            dp[ind+1][1][cap],
                            arr[ind]+dp[ind+1][0][cap-1]
                        );
                    }
                }
            }
        }

        return dp[0][0][k];
    }
}
------------Space Optimization-----------------------
class Solution {
    public int stockBuySell(int[] arr,int n,int k) {
        int[][] ahead = new int[2][k+1];
        int[][] cur = new int[2][k+1];

        for(int ind=n-1;ind>=0;ind--) {
            for(int buy=0;buy<=1;buy++) {
                for(int cap=1;cap<=k;cap++) {
                    if(buy == 0) {
                        cur[0][cap] = Math.max(
                            ahead[0][cap],
                            -arr[ind]+ahead[1][cap]
                        );
                    } else {
                        cur[1][cap] = Math.max(
                            ahead[1][cap],
                            arr[ind]+ahead[0][cap-1]
                        );
                    }
                }
            }

            int[][] temp = ahead;
            ahead = cur;
            cur = temp;
        }

        return ahead[0][k];
    }
}
