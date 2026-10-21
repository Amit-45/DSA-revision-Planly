import java.util.*;

class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        backtrack(0,nums,current,ans);
        return ans;
    }

    private void backtrack(int index,int[] nums,List<Integer> current,List<List<Integer>> ans) {
        // 1. When should I stop? All elements are processed
        if(index==nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // 2. First, exclude the current element and move to the next index
        backtrack(index+1,nums,current,ans);

        // 3. Now include the current element
        current.add(nums[index]);
        backtrack(index+1,nums,current,ans);

        // 4. Remove the last element to explore other possibilities
        current.remove(current.size()-1);
    }
}
