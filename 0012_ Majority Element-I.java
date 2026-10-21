

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
    int votes = 0;
    int candidate = 0;

    for (int x : nums) {
        if (votes == 0) {
            candidate = x;
        }

        if (x == candidate) {
            votes++;
        } else {
            votes--;
        }
    }

    return candidate;
    }
}

