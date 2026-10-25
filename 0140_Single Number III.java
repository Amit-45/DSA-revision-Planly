//XOR + Rightmost Set Bit (Bit Manipulation) Approach.
class Solution {
    public int[] singleNumber(int[] nums) {
        int XOR=0;
        for(int num:nums)
            XOR^=num; // 1. XOR all -> a^b

        int rightmost=XOR&(-XOR); // 2. Find rightmost set bit

        int XOR1=0,XOR2=0;
        for(int num:nums) {
            if((num&rightmost)!=0)
                XOR1^=num; // 3. Set bit -> group 1
            else
                XOR2^=num; // 3. Unset bit -> group 2
        }

        // 4. Return in sorted order
        if(XOR1<XOR2)
            return new int[]{XOR1,XOR2};
        return new int[]{XOR2,XOR1};
    }
}
