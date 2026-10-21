
class Solution {
    public int countSubsequenceWithTargetSum(int[] nums,int target) {
        return func(0,target,nums);
    }

    private int func(int index,int sum,int[] nums) {
        // 1. When should I stop successfully? Target becomes 0
        if(sum==0)return 1;

        // 2. If target becomes negative or elements finish, this path fails
        if(sum<0 || index==nums.length)return 0;

        // 3. First, take the current element
        int take=func(index+1,sum-nums[index],nums);

        // 4. Then, skip the current element
        int skip=func(index+1,sum,nums);

        // 5. Add the successful ways from both branches
        return take+skip; //COUNT
    }
}
