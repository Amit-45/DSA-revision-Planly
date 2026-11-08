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

class Solution {
    private boolean func(int ind,int target,int[] arr,int[][] dp) {
        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;

        if(dp[ind][target] != -1) {
            return dp[ind][target] == 1;
        }

        boolean notTake=func(ind-1,target,arr,dp);

        boolean take=false;
        if(arr[ind] <= target) {
            take=func(ind-1,target-arr[ind],arr,dp);
        }

        dp[ind][target]=(take || notTake) ? 1 : 0;

        return dp[ind][target] == 1;
    }

    public boolean subsetSumToK(int n,int k,int[] arr) {
        int[][] dp=new int[n][k+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }

        return func(n-1,k,arr,dp);
    }
}
-----------Tabu----------------
class Solution {
    public boolean subsetSumToK(int n,int k,int[] arr) {
        boolean[][] dp=new boolean[n][k+1];

        for(int i=0;i<n;i++) {
            dp[i][0]=true;
        }

        if(arr[0] <= k) {
            dp[0][arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            for(int target=1;target<=k;target++) {
                boolean notTake=dp[ind-1][target];

                boolean take=false;
                if(arr[ind] <= target) {
                    take=dp[ind-1][target-arr[ind]];
                }

                dp[ind][target]=take || notTake;
            }
        }

        return dp[n-1][k];
    }
}
--------Space Optimization-------------
class Solution {
    public boolean subsetSumToK(int n,int k,int[] arr) {
        boolean[] prev=new boolean[k+1];

        prev[0]=true;

        if(arr[0] <= k) {
            prev[arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++) {
            boolean[] cur=new boolean[k+1];

            cur[0]=true;

            for(int target=1;target<=k;target++) {
                boolean notTake=prev[target];

                boolean take=false;
                if(arr[ind] <= target) {
                    take=prev[target-arr[ind]];
                }

                cur[target]=take || notTake;
            }

            prev=cur;
        }

        return prev[k];
    }
}
