//BUCKETS CONCEPT : VERY NON INTUTIVE
class Solution {
    public int singleNumber(int[] nums) {
        int ones=0,twos=0; // Trigger: track bits seen once and twice

        for(int num:nums) {
            ones=(ones^num)&~twos; // Reason: add to ones, exclude twos
            twos=(twos^num)&~ones; // Reason: add to twos, exclude ones
        }

        return ones; // Trigger: unique number remains
    }
}
