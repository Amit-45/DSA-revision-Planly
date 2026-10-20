class Solution {
    public int secondLargestElement(int[] nums) {
         int n =nums.length; 
         int largest =Integer.MIN_VALUE;
         int secondlargest=Integer.MIN_VALUE;

         for(int i=0;i<n;i++){
            if(nums[i]>largest){
                secondlargest=largest;
                largest =nums[i];
            }
            else if(secondlargest<nums[i] && nums[i]<largest){
                secondlargest = nums[i];
            }
        }
     return secondlargest ==Integer.MIN_VALUE ? -1 : secondlargest;
    }
}
