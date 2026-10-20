class Solution {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        int first = nums[0];
        for(int i=1;i<n;i++){
            nums[i-1] =nums[i];
        }
        nums[n-1]=first;  
    }
}
