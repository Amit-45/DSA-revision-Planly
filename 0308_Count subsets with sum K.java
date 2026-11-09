---------------------Recur-----------------------------------
class Solution {
    private static final int MOD=1000000007;

    private int func(int ind,int target,int[] arr) {
        if(target==0) return 1;

        if(ind==0) {
            return arr[0]==target?1:0;
        }

        int notTake=func(ind-1,target,arr);

        int take=0;
        if(arr[ind]<=target) {
            take=func(ind-1,target-arr[ind],arr);
        }

        return (notTake+take)%MOD;
    }

    public int perfectSum(int[] arr,int K) {
        return func(arr.length-1,K,arr);
    }
}
----------------MEMO---------------------------------------

import java.util.*;

class Solution {
    private static final int MOD=1000000007;

    private int func(int ind,int target,int[] arr,int[][] dp) {
        if(target==0) return 1;

        if(ind==0) {
            return arr[0]==target?1:0;
        }

        if(dp[ind][target]!=-1) {
            return dp[ind][target];
        }

        int notTake=func(ind-1,target,arr,dp);

        int take=0;
        if(arr[ind]<=target) {
            take=func(ind-1,target-arr[ind],arr,dp);
        }

        return dp[ind][target]=(notTake+take)%MOD;
    }

    public int perfectSum(int[] arr,int K) {
        int n=arr.length;

        int[][] dp=new int[n][K+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }

        return func(n-1,K,arr,dp);
    }
}

------------------TABUL------------------------------

class Solution {
    private static final int MOD=1000000007;

    public int perfectSum(int[] arr,int K) {
        int n=arr.length;

        int[][] dp=new int[n][K+1];

        for(int i=0;i<n;i++) {
            dp[i][0]=1;
        }

        if(arr[0]<=K) {
            dp[0][arr[0]]=1;
        }

        for(int ind=1;ind<n;ind++) {
            for(int target=1;target<=K;target++) {
                int notTake=dp[ind-1][target];

                int take=0;
                if(arr[ind]<=target) {
                    take=dp[ind-1][target-arr[ind]];
                }

                dp[ind][target]=(notTake+take)%MOD;
            }
        }

        return dp[n-1][K];
    }
}

--------------SPACE OPTIMIZATION---------------------------

class Solution {
    private static final int MOD=1000000007;

    public int perfectSum(int[] arr,int K) {
        int n=arr.length;

        int[][] dp=new int[n][K+1];

        for(int i=0;i<n;i++) {
            dp[i][0]=1;
        }

        if(arr[0]<=K) {
            dp[0][arr[0]]=1;
        }

        for(int ind=1;ind<n;ind++) {
            for(int target=1;target<=K;target++) {
                int notTake=dp[ind-1][target];

                int take=0;
                if(arr[ind]<=target) {
                    take=dp[ind-1][target-arr[ind]];
                }

                dp[ind][target]=(notTake+take)%MOD;
            }
        }

        return dp[n-1][K];
    }
}
