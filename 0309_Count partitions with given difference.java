--------------Recur------------------------
class Solution {
    private static final int MOD=1000000007;

    private int func(int ind,int target,int[] arr) {
        if(ind==0) {
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }

        int notTake=func(ind-1,target,arr);

        int take=0;
        if(arr[ind]<=target) {
            take=func(ind-1,target-arr[ind],arr);
        }

        return (notTake+take)%MOD;
    }

    public int countPartitions(int n,int diff,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum-diff<0 || (totalSum-diff)%2!=0) return 0;

        int target=(totalSum-diff)/2;

        return func(n-1,target,arr);
    }
}

----------MEMO------------------------

import java.util.*;

class Solution {
    private static final int MOD=1000000007;

    private int func(int ind,int target,int[] arr,int[][] dp) {
        if(ind==0) {
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || target==arr[0]) return 1;
            return 0;
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

    public int countPartitions(int n,int diff,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum-diff<0 || (totalSum-diff)%2!=0) return 0;

        int target=(totalSum-diff)/2;

        int[][] dp=new int[n][target+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }

        return func(n-1,target,arr,dp);
    }
}
-------------TABU---------------------------------

class Solution {
    private static final int MOD=1000000007;

    public int countPartitions(int n,int diff,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum-diff<0 || (totalSum-diff)%2!=0) return 0;

        int target=(totalSum-diff)/2;

        int[][] dp=new int[n][target+1];

        if(arr[0]==0) {
            dp[0][0]=2;
        } else {
            dp[0][0]=1;
        }

        if(arr[0]!=0 && arr[0]<=target) {
            dp[0][arr[0]]=1;
        }

        for(int ind=1;ind<n;ind++) {
            for(int t=0;t<=target;t++) {
                int notTake=dp[ind-1][t];

                int take=0;
                if(arr[ind]<=t) {
                    take=dp[ind-1][t-arr[ind]];
                }

                dp[ind][t]=(notTake+take)%MOD;
            }
        }

        return dp[n-1][target];
    }
}

------------SPACE OPTI------------------------------------
class Solution {
    private static final int MOD=1000000007;

    public int countPartitions(int n,int diff,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum-diff<0 || (totalSum-diff)%2!=0) return 0;

        int target=(totalSum-diff)/2;

        int[] prev=new int[target+1];

        if(arr[0]==0) {
            prev[0]=2;
        } else {
            prev[0]=1;
        }

        if(arr[0]!=0 && arr[0]<=target) {
            prev[arr[0]]=1;
        }

        for(int ind=1;ind<n;ind++) {
            int[] cur=new int[target+1];

            for(int t=0;t<=target;t++) {
                int notTake=prev[t];

                int take=0;
                if(arr[ind]<=t) {
                    take=prev[t-arr[ind]];
                }

                cur[t]=(notTake+take)%MOD;
            }

            prev=cur;
        }

        return prev[target];
    }
}
