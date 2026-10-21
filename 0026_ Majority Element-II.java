import java.util.*;
class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        int votes1 = 0;
        int votes2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;

        for (int x : nums) {
            if (x == candidate1) {
                votes1++;
            }
            else if (x == candidate2) {
                votes2++;
            }
            else if (votes1 == 0) {
                candidate1 = x;
                votes1 = 1;
            }
            else if (votes2 == 0) {
                candidate2 = x;
                votes2 = 1;
            }
            else {
                votes1--;
                votes2--;
            }
        }

        int count1 = 0;
        int count2 = 0;

        for (int x : nums) {
            if (x == candidate1) {
                count1++;
            }
            else if (x == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }
}
