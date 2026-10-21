
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] nums,int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(0,nums,target,new ArrayList<>(),ans);
        return ans;
    }

    private void backtrack(int index,int[] nums,int target,List<Integer> current,List<List<Integer>> ans) {
        // 1. target==0 → Save the current combination
        if(target==0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // 2. No elements remain → Stop this branch
        if(index==nums.length)return;

        // 3. Take: Add the current element and stay at the same index
        if(nums[index]<=target) {
            current.add(nums[index]);
            backtrack(index,nums,target-nums[index],current,ans);

            // 4. Backtrack: Remove the last added element
            current.remove(current.size()-1);
        }

        // 5. Not take: Move to the next index
        backtrack(index+1,nums,target,current,ans);
    }
}
