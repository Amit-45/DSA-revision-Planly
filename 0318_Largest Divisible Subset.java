-----Tabulation + Parent Array (LIS Pattern)----------------------------
import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;

        // 1. Sort the array
        Arrays.sort(nums);

        List<Integer> ans=new ArrayList<>();

        // 2. Initialize DP and parent
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int[] parent=new int[n];

        int lastIndex=0;
        int maxLen=0;

        // 3. Nested loops + divisibility condition
        for(int i=0;i<n;i++){
            parent[i]=i;
            for(int prevInd=0;prevInd<i;prevInd++){
                if(nums[i]%nums[prevInd]==0 &&
                   dp[i]<dp[prevInd]+1){
                    // 4. Update DP and parent
                    dp[i]=dp[prevInd]+1;
                    parent[i]=prevInd;
                }
            }
            // Track maximum length and ending index
            if(dp[i]>maxLen){
                maxLen=dp[i];
                lastIndex=i;
            }
        }
      
        // 5. Backtrack using parent array
        int i=lastIndex;

        while(parent[i]!=i){
            ans.add(nums[i]);
            i=parent[i];
        }

        ans.add(nums[i]);
        return ans;
    }
}
