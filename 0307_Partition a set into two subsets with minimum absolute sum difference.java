class Solution {
    private boolean func(int ind,int target,int[] arr) {
        if(target==0) return true;
        if(ind==0) return arr[0]==target;

        boolean notTake=func(ind-1,target,arr);

        boolean take=false;
        if(arr[ind]<=target) {
            take=func(ind-1,target-arr[ind],arr);
        }

        return take||notTake;
    }

    public int minDifference(int[] arr,int n) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        int mini=Integer.MAX_VALUE;

        for(int target=0;target<=totalSum;target++) {
            if(func(n-1,target,arr)) {
                int diff=Math.abs(target-(totalSum-target));
                mini=Math.min(mini,diff);
            }
        }

        return mini;
    }
}
-----------------------MEMO------------------------------------

import java.util.*;

class Solution {
    private boolean func(int ind,int target,int[] arr,int[][] dp) {
        if(target==0) return true;

        if(ind==0) return arr[0]==target;

        if(dp[ind][target]!=-1) {
            return dp[ind][target]==1;
        }

        boolean notTake=func(ind-1,target,arr,dp);

        boolean take=false;
        if(arr[ind]<=target) {
            take=func(ind-1,target-arr[ind],arr,dp);
        }

        dp[ind][target]=(take||notTake)?1:0;

        return dp[ind][target]==1;
    }

    public int minDifference(int[] arr,int n) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        int[][] dp=new int[n][totalSum+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }

        int mini=Integer.MAX_VALUE;

        for(int target=0;target<=totalSum;target++) {
            if(func(n-1,target,arr,dp)) {
                int diff=Math.abs(target-(totalSum-target));
                mini=Math.min(mini,diff);
            }
        }

        return mini;
    }
}
-------------TABU------------------------------
class Solution {
    public int minDifference(int[] arr,int n) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        boolean[][] dp=new boolean[n][totalSum+1];

        for(int i=0;i<n;i++) {
            dp[i][0]=true;
        }

        if(arr[0]<=totalSum) {
            dp[0][arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            for(int t=1;t<=totalSum;t++) {
                boolean notTake=dp[ind-1][t];

                boolean take=false;
                if(arr[ind]<=t) {
                    take=dp[ind-1][t-arr[ind]];
                }

                dp[ind][t]=take||notTake;
            }
        }

        int mini=Integer.MAX_VALUE;

        for(int target=0;target<=totalSum;target++) {
            if(dp[n-1][target]) {
                int diff=Math.abs(target-(totalSum-target));
                mini=Math.min(mini,diff);
            }
        }

        return mini;
    }
}
-------------SPACE OPTI-----------------------------------
class Solution {
    public int minDifference(int[] arr,int n) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        boolean[] prev=new boolean[totalSum+1];

        prev[0]=true;

        if(arr[0]<=totalSum) {
            prev[arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            boolean[] cur=new boolean[totalSum+1];

            cur[0]=true;

            for(int t=1;t<=totalSum;t++) {
                boolean notTake=prev[t];

                boolean take=false;
                if(arr[ind]<=t) {
                    take=prev[t-arr[ind]];
                }

                cur[t]=take||notTake;
            }

            prev=cur;
        }

        int mini=Integer.MAX_VALUE;

        for(int target=0;target<=totalSum;target++) {
            if(prev[target]) {
                int diff=Math.abs(target-(totalSum-target));
                mini=Math.min(mini,diff);
            }
        }

        return mini;
    }
}
