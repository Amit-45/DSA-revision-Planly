class Solution {
    public int maxScore(int[] cardScore,int k) {
        int lSum=0,rSum=0,maxSum=0;

        // 1. Take first k cards
        for(int i=0;i<k;i++) {
            lSum+=cardScore[i];
            maxSum=lSum;
        }

        // 2. Start from the right end
        int rightIndex=cardScore.length-1;

        // 3. Exchange left cards for right cards
        for(int i=k-1;i>=0;i--) {
            lSum-=cardScore[i];                 // Remove left
            rSum+=cardScore[rightIndex--];      // Add right
            maxSum=Math.max(maxSum,lSum+rSum);  // Update max
        }

        return maxSum;
    }
}
