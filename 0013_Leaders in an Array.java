class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int p = 0, q = 1;
        for (int x : nums) {
            if (x > 0) {
                ans[p] = x;
                p += 2;
            } else {
                ans[q] = x;
                q += 2;
            }
        }
        return ans;
    }
}
