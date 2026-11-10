------------------State Augmentation (DP array + Parent Array)--------------------------
import java.util.*;
class Solution {
    public List<Integer> longestIncreasingSubsequence(int[] arr) {
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();

        // 1. Create DP and Parent arrays
        int[] dp=new int[n];
        int[] parent=new int[n];

        int lastIndex=0;
        int maxLen=0;

        // 2. Initialize DP with 1
        Arrays.fill(dp,1);

        // 3. Traverse every index
        for(int i=0;i<n;i++) {
            parent[i]=i;

            // 4. Check all previous indices
            for(int prevInd=0;prevInd<i;prevInd++) {

                if(arr[prevInd]<arr[i]) {

                    // 5. Found a longer LIS
                    if(dp[i]<dp[prevInd]+1) {
                        dp[i]=dp[prevInd]+1;
                        parent[i]=prevInd;
                    }

                    // 6. Same length → choose earlier index
                    else if(dp[i]==dp[prevInd]+1 && prevInd<parent[i]) {
                        parent[i]=prevInd;
                    }
                }
            }

            // 7. Track maximum length and ending index
            if(dp[i]>maxLen) {
                lastIndex=i;
                maxLen=dp[i];
            }
        }

        // 8. Backtrack using parent array
        int i=lastIndex;

        while(parent[i]!=i) {
            ans.add(arr[i]);
            i=parent[i];
        }
        ans.add(arr[i]);

        // 9. Reverse and return
        Collections.reverse(ans);
        return ans;
    }
}

