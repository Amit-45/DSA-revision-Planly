
class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2; // Start from second-last index to compare i and i+1

        // Step 1: Find the breaking point (first increasing pair from right)
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }

        // Step 2: If breaking point exists, find next greater element and swap
        if(i>=0){
            int j=n-1; // Start searching from the last index

            // Skip elements smaller than or equal to breaking point
            while(nums[j]<=nums[i]){
                j--;
            }

            // Swap breaking point with the next greater element
            swap(nums,i,j);
        }

        // Step 3: Reverse suffix to make it ascending (smallest possible)
        reverse(nums,i+1,n-1);
    }

    // Swap two elements
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    // Reverse elements between i and j
    private void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
