----------RECUR------------------------------------------------

f(ind,buy,fee) {
    if(ind == n) return 0;

    if(buy == 0) {
        op1 = 0 + f(ind+1,0,fee);
        op2 = -arr[ind] + f(ind+1,1,fee);
    }

    if(buy == 1) {
        op1 = 0 + f(ind+1,1,fee);
        op2 = arr[ind]-fee + f(ind+1,0,fee);
    }

    return max(op1,op2);
}
-----------------MEMO---------------------------------------
import java.util.*;

class Solution {
    private int func(int ind,int buy,int fee,int n,int[] arr,int[][] dp) {
        if(ind == n) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit=0;

        if(buy == 0) {
            int op1=func(ind+1,0,fee,n,arr,dp);
            int op2=-arr[ind]+func(ind+1,1,fee,n,arr,dp);
            profit=Math.max(op1,op2);
        } else {
            int op1=func(ind+1,1,fee,n,arr,dp);
            int op2=arr[ind]-fee+func(ind+1,0,fee,n,arr,dp);
            profit=Math.max(op1,op2);
        }

        return dp[ind][buy]=profit;
    }

    public int stockBuySell(int[] arr,int n,int fee) {
        int[][] dp=new int[n][2];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }

        return func(0,0,fee,n,arr,dp);
    }
}
-------------TABU-----------------------------------
class Solution {
    public int stockBuySell(int[] arr,int n,int fee) {
        int[][] dp=new int[n+1][2];

        for(int ind=n-1;ind>=0;ind--) {
            for(int buy=0;buy<=1;buy++) {
                if(buy == 0) {
                    dp[ind][buy]=Math.max(
                        dp[ind+1][0],
                        -arr[ind]+dp[ind+1][1]
                    );
                } else {
                    dp[ind][buy]=Math.max(
                        dp[ind+1][1],
                        arr[ind]-fee+dp[ind+1][0]
                    );
                }
            }
        }

        return dp[0][0];
    }
}
----------SPACE OPTI-----------------
class Solution {
    public int stockBuySell(int[] arr,int n,int fee) {
        int[] ahead=new int[2];
        int[] cur=new int[2];

        for(int ind=n-1;ind>=0;ind--) {
            cur[0]=Math.max(ahead[0],-arr[ind]+ahead[1]);
            cur[1]=Math.max(ahead[1],arr[ind]-fee+ahead[0]);

            ahead[0]=cur[0];
            ahead[1]=cur[1];
        }

        return ahead[0];
    }
}
