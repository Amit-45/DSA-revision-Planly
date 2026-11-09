-------------RECUR---------------------------------
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

    public boolean equalPartition(int n,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum%2!=0) return false;

        int target=totalSum/2;

        return func(n-1,target,arr);
    }
}
--------------Memo-----------------------------
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

        dp[ind][target]=(notTake||take)?1:0;

        return dp[ind][target]==1;
    }

    public boolean equalPartition(int n,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum%2!=0) return false;

        int target=totalSum/2;

        int[][] dp=new int[n][target+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }

        return func(n-1,target,arr,dp);
    }
}
---------------Tabu----------------------------------
class Solution {
    public boolean equalPartition(int n,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum%2!=0) return false;

        int target=totalSum/2;

        boolean[][] dp=new boolean[n][target+1];

        for(int i=0;i<n;i++) {
            dp[i][0]=true;
        }

        if(arr[0]<=target) {
            dp[0][arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            for(int t=1;t<=target;t++) {
                boolean notTake=dp[ind-1][t];

                boolean take=false;
                if(arr[ind]<=t) {
                    take=dp[ind-1][t-arr[ind]];
                }

                dp[ind][t]=take||notTake;
            }
        }

        return dp[n-1][target];
    }
}
----------------Space opti---------------------------------------------
class Solution {
    public boolean equalPartition(int n,int[] arr) {
        int totalSum=0;

        for(int i=0;i<n;i++) {
            totalSum+=arr[i];
        }

        if(totalSum%2!=0) return false;

        int target=totalSum/2;

        boolean[] prev=new boolean[target+1];

        prev[0]=true;

        if(arr[0]<=target) {
            prev[arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            boolean[] cur=new boolean[target+1];

            cur[0]=true;

            for(int t=1;t<=target;t++) {
                boolean notTake=prev[t];

                boolean take=false;
                if(arr[ind]<=t) {
                    take=prev[t-arr[ind]];
                }

                cur[t]=take||notTake;
            }

            prev=cur;
        }

        return prev[target];
    }
}
