class Solution {
    public int[] selectionSort(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            int minIndex=i;
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j]<nums[minIndex]) {
                    minIndex=j;
                }
            }
            if(minIndex!=i) {
                int temp=nums[i];
                nums[i]=nums[minIndex];
                nums[minIndex]=temp;
            }
        }

        return nums;
    }
}
