import java.util.*;

class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        int count=1<<n; // 1. Count: total subsets = 2^n

        for(int val=0;val<count;val++) { // 2. Generate every subset pattern
            List<Integer> subset=new ArrayList<>();

            for(int i=0;i<n;i++) {
                // 3. Check bit: 1 means include, 0 means exclude
                if((val&(1<<i))!=0)
                    subset.add(nums[i]); // 4. Include element if bit is set
            }

            ans.add(subset); // 5. Store the generated subset
        }

        return ans;
    }
}
