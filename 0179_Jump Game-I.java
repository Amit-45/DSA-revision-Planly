class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex=0;
        // Traverse each index
        for(int i=0;i<nums.length;i++) {
            // Check if current index is reachable
            if(i>maxIndex) return false;
            // Update farthest reachable index
            maxIndex=Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }
}
