class Solution {
    public int longestOnes(int[] nums,int k) {
        int l=0,zeros=0,maxLen=0;

        for(int r=0;r<nums.length;r++) {
            // 1. Expand window: count incoming zero
            if(nums[r]==0) zeros++;

            // 2. Handle invalid window: zeros > k
            if(zeros>k) {
                // 3. Remove outgoing zero
                if(nums[l]==0) zeros--;

                // 4. Shrink window from left
                l++;
            }

            // 5. Update maximum window length
            maxLen=Math.max(maxLen,r-l+1);
        }

        // 6. Return answer
        return maxLen;
    }
}
