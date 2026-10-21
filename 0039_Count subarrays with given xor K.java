import java.util.*;

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int xr = 0, cnt = 0;

        // INITIAL XOR = 0 KO MAP MEIN SAVE KARO
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            // XOR BANAO
            xr = xr ^ nums[i];

            // XOR ^ K → MAP MEIN DHOONDO
            int x = xr ^ k;

            // MILA → UTNE SUBARRAYS COUNT KARO
            cnt += map.getOrDefault(x, 0);

            // CURRENT XOR KI FREQUENCY SAVE KARO
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return cnt;
    }
}
