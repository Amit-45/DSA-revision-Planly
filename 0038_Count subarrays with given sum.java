import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Starting point ke liye 0 ko 1 baar rakho
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            // SUM BANAO
            sum += nums[i];

            // SUM - K NIKALO
            int rem = sum - k;

            // MAP MEIN DHOONDO → MILA TO COUNT BADHAO
            count += map.getOrDefault(rem, 0);

            // CURRENT SUM KO MAP MEIN ADD KARO
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
