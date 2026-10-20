class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int n = nums.length;
    int counter = 0;
    int maxii = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) {
        counter++;
        maxii = Math.max(counter, maxii);
      } else {
        counter = 0;
      }
    }

    return maxii;
  }
}
