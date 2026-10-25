class Solution {
    public int singleNumber(int[] nums) {
        int XOR=0; // Trigger: start with 0 because a^0=a

        for(int i=0;i<nums.length;i++) {
            XOR^=nums[i]; // Trigger: cancel duplicate pairs
        }

        return XOR; // Trigger: only the single number survives
    }
}
