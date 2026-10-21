
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k,int n) {
        List<List<Integer>> ans=new ArrayList<>();
        func(n,1,new ArrayList<>(),k,ans);
        return ans;
    }

    private void func(int sum,int last,List<Integer> nums,int k,List<List<Integer>> ans) {
        // 1. Target reached with exactly k numbers? Save the combination
        if(sum==0&&nums.size()==k) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        // 2. Invalid path? Stop
        if(sum<=0||nums.size()>k)return;

        // 3. Try each number from last to 9
        for(int i=last;i<=9;i++) {
            // 4. If the number is too large, stop trying larger numbers
            if(i>sum)break;

            // 5. TAKE the number
            nums.add(i);
            func(sum-i,i+1,nums,k,ans);

            // 6. BACKTRACK
            nums.remove(nums.size()-1);
        }
    }
}
