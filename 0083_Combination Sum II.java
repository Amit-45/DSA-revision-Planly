
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates,int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }

    private void backtrack(int ind,int[] candidates,int target,List<Integer> nums,List<List<Integer>> ans) {
        if(target==0) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        if(ind==candidates.length)return;

        // TAKE: move to the next index (no reuse)
        if(candidates[ind]<=target) {
            nums.add(candidates[ind]);
            backtrack(ind+1,candidates,target-candidates[ind],nums,ans);

            // BACKTRACK: remove the last number
            nums.remove(nums.size()-1);
        }

        // SKIP: jump over duplicates
        int next=ind+1;
        while(next<candidates.length&&candidates[next]==candidates[ind]) {
            next++;
        }
        backtrack(next,candidates,target,nums,ans);
    }
}
