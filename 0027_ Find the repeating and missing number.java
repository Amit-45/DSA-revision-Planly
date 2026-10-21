class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n=nums.length;
        long S=(long)n*(n+1)/2;
        long P=(long)n*(n+1)*(2*n+1)/6;

        for(int x:nums){
            S-=x;
            P-=(long)x*x;
        }
        long missing=(S+P/S)/2;
        long repeating=missing-S;
        return new int[]{(int)repeating,(int)missing};
    }
}
