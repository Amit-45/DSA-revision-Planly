
import java.util.*;

class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        func(0,0,nums,ans);
        return ans;
    }

    private void func(int ind,int sum,int[] nums,List<Integer> ans) {
        if(ind==nums.length) {
            ans.add(sum);
            return;
        }

        // TAKE
        func(ind+1,sum+nums[ind],nums,ans);

        // NOT TAKE
        func(ind+1,sum,nums,ans);
    }
}
