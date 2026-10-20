class Solution {
    public int largestElement(int[] nums) {
       int n=nums.length;
       int maxi =nums[0];
       for(int i=1;i<n;i++){
         if(nums[i]>maxi){
         maxi =nums[i];
       }
    }  
    return maxi;
}

}
