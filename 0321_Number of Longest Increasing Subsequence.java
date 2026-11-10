import java.util.*;

class Solution {
    public int numberOfLIS(int[] nums) {
        int n=nums.length;

        // 1. CREATE DP + COUNT ARRAYS
        int[] dp=new int[n];
        int[] count=new int[n];

        // 2. INITIALIZE BOTH WITH 1
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        int maxLen=0;

        // 3. TRAVERSE EVERY INDEX
        for(int i=0;i<n;i++) {

            // 4. CHECK ALL PREVIOUS INDICES
            for(int prevInd=0;prevInd<i;prevInd++) {

                if(nums[prevInd]<nums[i]) {

                    // 5. LONGER LIS → UPDATE DP + COPY COUNT
                    if(dp[i]<dp[prevInd]+1) {
                        dp[i]=dp[prevInd]+1;
                        count[i]=count[prevInd];
                    }

                    // 6. SAME LENGTH → ADD COUNT
                    else if(dp[i]==dp[prevInd]+1) {
                        count[i]+=count[prevInd];
                    }
                }
            }

            // 7. TRACK MAXIMUM LIS LENGTH
            maxLen=Math.max(maxLen,dp[i]);
        }

        // 8. SUM COUNTS OF ALL MAXIMUM-LENGTH LIS
        int ans=0;

        for(int i=0;i<n;i++) {
            if(dp[i]==maxLen) {
                ans+=count[i];
            }
        }

        // 9. RETURN ANSWER
        return ans;
    }
}
