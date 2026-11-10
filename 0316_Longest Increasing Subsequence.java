Binary search is the most optimal for this question(solution at last)
---------------------RECUR-------------------------------------------
class Solution {
    private int func(int ind, int prevInd, int[] nums) {
        if(ind == nums.length) return 0;

        int notTake = func(ind+1, prevInd, nums);

        int take = 0;

        if(prevInd == -1 || nums[ind] > nums[prevInd]) {
            take = 1 + func(ind+1, ind, nums);
        }
        return Math.max(take, notTake);
    }
    public int LIS(int[] nums) {
        return func(0, -1, nums);
    }
}
----------------MEMO---------------------------------

import java.util.*;

class Solution {
    private int func(int ind,int prevInd,int[] nums,int[][] dp) {
        if(ind==nums.length) return 0;

        if(dp[ind][prevInd+1]!=-1)
            return dp[ind][prevInd+1];

        int notTake=func(ind+1,prevInd,nums,dp);

        int take=0;

        if(prevInd==-1 || nums[ind]>nums[prevInd]) {
            take=1+func(ind+1,ind,nums,dp);
        }

        return dp[ind][prevInd+1]=Math.max(take,notTake);
    }

    public int LIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];

        for(int[] row:dp)
            Arrays.fill(row,-1);

        return func(0,-1,nums,dp);
    }
}
----------------------TABU------------------------------------------
class Solution {
    public int LIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];

        for(int ind=n-1;ind>=0;ind--) {
            for(int prevInd=ind-1;prevInd>=-1;prevInd--) {

                int notTake=dp[ind+1][prevInd+1];

                int take=0;

                if(prevInd==-1 || nums[ind]>nums[prevInd]) {
                    take=1+dp[ind+1][ind+1];
                }

                dp[ind][prevInd+1]=Math.max(take,notTake);
            }
        }

        return dp[0][0];
    }
}
-------------------SPACE OPTI--------------------------------------

class Solution {
    public int LIS(int[] nums) {
        int n=nums.length;

        int[] next=new int[n+1];

        for(int ind=n-1;ind>=0;ind--) {
            int[] cur=new int[n+1];

            for(int prevInd=ind-1;prevInd>=-1;prevInd--) {

                int notTake=next[prevInd+1];

                int take=0;

                if(prevInd==-1 || nums[ind]>nums[prevInd]) {
                    take=1+next[ind+1];
                }

                cur[prevInd+1]=Math.max(take,notTake);
            }

            next=cur;
        }

        return next[0];
    }
}
-------------------Binary Search - Patience sort+ Lower Bound(OPTIMAL)-----------------------------------------
import java.util.*;
class Solution {
    public int LIS(int[] nums) {
        int n=nums.length;

        // 1. Create temp and add first element
        List<Integer> temp=new ArrayList<>();
        temp.add(nums[0]);

        // 2. Traverse remaining elements
        for(int i=1;i<n;i++) {

            // 3. If greater than last → append
            if(nums[i]>temp.get(temp.size()-1)) {
                temp.add(nums[i]);
            }
            // 4. Otherwise → find Lower Bound and replace
            else {
                int ind=Collections.binarySearch(temp,nums[i]);

                // 5. Convert negative result to insertion index
                if(ind<0) ind=-(ind+1);

                temp.set(ind,nums[i]);
            }
        }

        // 6. Return LIS length
        return temp.size();
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};

        Solution sol=new Solution();
        System.out.println(sol.LIS(nums));
    }
}

