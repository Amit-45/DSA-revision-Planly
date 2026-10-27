class Solution {
    public int numSubarraysWithSum(int[] nums,int goal){
        return atMost(nums,goal)-atMost(nums,goal-1); // Exactly goal = atMost(goal) - atMost(goal-1)
    }

    private int atMost(int[] nums,int goal){
        if(goal<0) return 0; // Negative sum is impossible

        int l=0,sum=0,count=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r]; // Expand window

            while(sum>goal){
                sum-=nums[l]; // Shrink window
                l++;
            }

            count+=r-l+1; // Count valid subarrays ending at r
        }
        return count;
    }
}
