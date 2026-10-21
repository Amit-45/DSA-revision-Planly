class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxi = Integer.MIN_VALUE;
        for (int x : nums) {
            sum += x;
            maxi = Math.max(maxi, sum);
            if (sum < 0) sum = 0;
        }
        return maxi;
    }
}
