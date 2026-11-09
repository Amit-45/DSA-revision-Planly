----------------Recur-------------------------------------
class Solution {
    private int func(int[] arr,int ind,int target) {
        if(target==0) return 1;

        if(ind==0) {
            return target%arr[0]==0?1:0;
        }

        int notTake=func(arr,ind-1,target);

        int take=0;
        if(arr[ind]<=target) {
            take=func(arr,ind,target-arr[ind]);
        }

        return Math.min(take,notTake);
    }

    public int MinimumCoins(int[] arr,int target) {
        return func(arr,arr.length-1,target);
    }
}
--------Memo-------------------------
import java.util.*;

class Solution {
    private int func(int[] arr,int ind,int T,int[][] dp) {
        if(T==0) return 0;

        if(ind==0) {
            if(T%arr[0]==0) return T/arr[0];
            return (int)1e9;
        }

        if(dp[ind][T]!=-1) return dp[ind][T];

        int notTake=func(arr,ind-1,T,dp);

        int take=(int)1e9;
        if(arr[ind]<=T) {
            take=1+func(arr,ind,T-arr[ind],dp);
        }

        return dp[ind][T]=Math.min(take,notTake);
    }

    public int MinimumCoins(int[] arr,int amount) {
        int n=arr.length;
        int[][] dp=new int[n][amount+1];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        int ans=func(arr,n-1,amount,dp);

        return ans>=(int)1e9?-1:ans;
    }
}
----------TABU-----------------------------
class Solution {
    public int MinimumCoins(int[] arr,int amount) {
        int n=arr.length;
        int inf=(int)1e9;

        int[][] dp=new int[n][amount+1];

        for(int T=0;T<=amount;T++) {
            if(T%arr[0]==0) dp[0][T]=T/arr[0];
            else dp[0][T]=inf;
        }

        for(int ind=1;ind<n;ind++) {
            for(int T=0;T<=amount;T++) {
                int notTake=dp[ind-1][T];

                int take=inf;
                if(arr[ind]<=T) {
                    take=1+dp[ind][T-arr[ind]];
                }

                dp[ind][T]=Math.min(take,notTake);
            }
        }

        int ans=dp[n-1][amount];
        return ans>=inf?-1:ans;
    }
}
--------------OPTI-----------------------------
class Solution {
    public int MinimumCoins(int[] arr,int amount) {
        int n=arr.length;
        int inf=(int)1e9;

        int[] prev=new int[amount+1];

        for(int T=0;T<=amount;T++) {
            if(T%arr[0]==0) prev[T]=T/arr[0];
            else prev[T]=inf;
        }

        for(int ind=1;ind<n;ind++) {
            int[] cur=new int[amount+1];
            cur[0]=0;

            for(int T=1;T<=amount;T++) {
                int notTake=prev[T];

                int take=inf;
                if(arr[ind]<=T) {
                    take=1+cur[T-arr[ind]];
                }

                cur[T]=Math.min(take,notTake);
            }

            prev=cur;
        }

        int ans=prev[amount];
        return ans>=inf?-1:ans;
    }
}
