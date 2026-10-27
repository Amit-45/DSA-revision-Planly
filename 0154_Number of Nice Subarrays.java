class Solution {
    public int numberOfOddSubarrays(int[] nums,int k){
        return helper(nums,k)-helper(nums,k-1); // Exactly k = atMost(k) - atMost(k-1)
    }
    private int helper(int[] nums,int goal){
        if(goal<0) return 0; // Negative goal is impossible
        int l=0,sum=0,count=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r]%2; // Odd = 1, even = 0
            while(sum>goal){
                sum-=nums[l]%2; // Remove left element
                l++;
            }
            count+=r-l+1; // Count valid subarrays ending at r
        }
        return count;
    }
}
