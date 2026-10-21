import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums); // SORTING REQD to put the duplicate values together 
        backtrack(0,nums,new ArrayList<>(),ans);
        return ans;
    }

    private void backtrack(int index,int[] nums,List<Integer> current,List<List<Integer>> ans) {
        if(index==nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // NOT TAKE: skip current element and its duplicates
        int next=index+1;
        while(next<nums.length&&nums[next]==nums[index]) {
            next++;
        }
        backtrack(next,nums,current,ans);

        // TAKE: include current element
        current.add(nums[index]);
        backtrack(index+1,nums,current,ans);

        // BACKTRACK: remove last added element
        current.remove(current.size()-1);
    }
}
