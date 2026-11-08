-----------Recur-------------------------------
f(ind,target) {
    if(target == 0) return true;
    if(ind == 0) return arr[0] == target;

    notTake = f(ind-1,target);

    take = false;
    if(arr[ind] <= target) {
        take = f(ind-1,target-arr[ind]);
    }

    return take || notTake;
}
---------------Memo----------------------------
import java.util.*;
//MEMO
class Solution {
    private boolean func(int ind,int target,int[] arr,int[][] dp) {
        if(target==0)
            return true;

        if(ind==0)
            return arr[0]==target;

        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        boolean notTaken=func(ind-1,target,arr,dp);

        boolean taken=false;
        if(arr[ind]<=target)
            taken=func(ind-1,target-arr[ind],arr,dp);

        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }

    public boolean isSubsetSum(int[] arr,int target) {
        int dp[][]=new int[arr.length][target+1];

        for(int row[]:dp)
            Arrays.fill(row,-1);

        return func(arr.length-1,target,arr,dp);
    }
}
-----------Tabu----------------
class Solution {
    //TABU
    private boolean func(int n,int target,int[] arr) {
        boolean[][] dp=new boolean[n][target+1];

        for(int i=0;i<n;i++) {
            dp[i][0]=true;
        }

        if(arr[0]<=target) {
            dp[0][arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            for(int t=1;t<=target;t++) {
                boolean notTaken=dp[ind-1][t];

                boolean taken=false;
                if(arr[ind]<=t) {
                    taken=dp[ind-1][t-arr[ind]];
                }

                dp[ind][t]=notTaken||taken;
            }
        }

        return dp[n-1][target];
    }

    public boolean isSubsetSum(int[] arr,int target) {
        return func(arr.length,target,arr);
    }

}
--------Space Optimization-------------
class Solution {
    private boolean func(int n,int target,int[] arr) {
        boolean[] prev=new boolean[target+1];

        prev[0]=true;

        if(arr[0]<=target) {
            prev[arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            boolean[] cur=new boolean[target+1];

            cur[0]=true;

            for(int i=1;i<=target;i++) {
                boolean notTaken=prev[i];

                boolean taken=false;
                if(arr[ind]<=i) {
                    taken=prev[i-arr[ind]];
                }

                cur[i]=notTaken||taken;
            }

            prev=cur;
        }

        return prev[target];
    }

    public boolean isSubsetSum(int[] arr,int target) {
        return func(arr.length,target,arr);
    }
}
