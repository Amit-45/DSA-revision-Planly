------------------RECUR----------------------------
class Solution {
    private int MOD=(int)1e9+7;

    private int func(int ind,int target,int[] arr) {
        if(ind==0) {
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || target==arr[0]) return 1;
            return 0;
        }

        int notTaken=func(ind-1,target,arr);

        int taken=0;
        if(arr[ind]<=target)
            taken=func(ind-1,target-arr[ind],arr);

        return (notTaken+taken)%MOD;
    }

    public int targetSum(int n,int target,int[] nums) {
        int totSum=0;
        for(int num:nums) totSum+=num;

        if(totSum-target<0) return 0;
        if((totSum-target)%2!=0) return 0;

        int s2=(totSum-target)/2;

        return func(n-1,s2,nums);
    }
}

------------------MEMO-----------------------------
import java.util.*;
class Solution {
    private int MOD=(int)1e9+7;

    private int func(int ind,int target,int[] arr,int[][] dp) {
        if(ind==0) {
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || target==arr[0]) return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken=func(ind-1,target,arr,dp);

        int taken=0;
        if(arr[ind]<=target)
            taken=func(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]=(notTaken+taken)%MOD;
    }

    public int targetSum(int n,int target,int[] nums) {
        int totSum=0;
        for(int num:nums) totSum+=num;

        if(totSum-target<0) return 0;
        if((totSum-target)%2!=0) return 0;

        int s2=(totSum-target)/2;

        int[][] dp=new int[n][s2+1];
        for(int[] row:dp) Arrays.fill(row,-1);

        return func(n-1,s2,nums,dp);
    }
}
---------------------TABU------------------------

import java.util.*;

class Solution {
    private int MOD=(int)1e9+7;

    public int targetSum(int n,int target,int[] nums) {
        int totSum=0;
        for(int num:nums) totSum+=num;

        if(totSum-target<0) return 0;
        if((totSum-target)%2!=0) return 0;

        int s2=(totSum-target)/2;

        int[][] dp=new int[n][s2+1];

        if(nums[0]==0)
            dp[0][0]=2;
        else
            dp[0][0]=1;

        if(nums[0]!=0 && nums[0]<=s2)
            dp[0][nums[0]]=1;

        for(int ind=1;ind<n;ind++) {
            for(int sum=0;sum<=s2;sum++) {
                int notTaken=dp[ind-1][sum];

                int taken=0;
                if(nums[ind]<=sum)
                    taken=dp[ind-1][sum-nums[ind]];

                dp[ind][sum]=(notTaken+taken)%MOD;
            }
        }

        return dp[n-1][s2];
    }
}

-----------------SPACE OPTI------------------------------

import java.util.*;

class Solution {
    private int MOD=(int)1e9+7;

    public int targetSum(int n,int target,int[] nums) {
        int totSum=0;
        for(int num:nums) totSum+=num;

        if(totSum-target<0) return 0;
        if((totSum-target)%2!=0) return 0;

        int s2=(totSum-target)/2;

        int[] prev=new int[s2+1];

        if(nums[0]==0)
            prev[0]=2;
        else
            prev[0]=1;

        if(nums[0]!=0 && nums[0]<=s2)
            prev[nums[0]]=1;

        for(int ind=1;ind<n;ind++) {
            int[] curr=new int[s2+1];

            for(int sum=0;sum<=s2;sum++) {
                int notTaken=prev[sum];

                int taken=0;
                if(nums[ind]<=sum)
                    taken=prev[sum-nums[ind]];

                curr[sum]=(notTaken+taken)%MOD;
            }

            prev=curr;
        }

        return prev[s2];
    }
}
