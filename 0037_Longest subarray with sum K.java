import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            // SUM BANAO
            sum += nums[i];

            // SUM == K → LENGTH NIKALO
            if (sum == k)
                maxLen = Math.max(maxLen, i + 1);

            // SUM - K → MAP MEIN DHOONDO
            int rem = sum - k;

            // MILA → LENGTH NIKALO
            if (map.containsKey(rem))
                maxLen = Math.max(maxLen, i - map.get(rem));

            // SUM KA FIRST INDEX SAVE KARO
            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return maxLen;
    }
}
