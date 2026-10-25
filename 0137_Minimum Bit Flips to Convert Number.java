class Solution {
    public int minBitsFlip(int start,int goal) {
        int num=start^goal; // Trigger: XOR -> find different bits
        int count=0;        // Trigger: count the different bits

        while(num!=0) {
            count+=num&1;   // Trigger: check last bit -> count if 1
            num=num>>>1;    // Trigger: shift right -> move to next bit
        }

        return count;       // Trigger: return total flips
    }
}
