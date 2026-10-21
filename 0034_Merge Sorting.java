class Solution {
    public void merge(int[] arr,int low,int mid,int high) {
        // Merge two sorted halves
        List<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;

        // Compare both halves
        while(left<=mid && right<=high) {
            if(arr[left]<=arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        // Add remaining left elements
        while(left<=mid) {
            temp.add(arr[left++]);
        }

        // Add remaining right elements
        while(right<=high) {
            temp.add(arr[right++]);
        }

        // Copy sorted elements back
        for(int i=low;i<=high;i++) {
            arr[i]=temp.get(i-low);
        }
    }

    public void mergeSortHelper(int[] arr,int low,int high) {
        // Base case
        if(low>=high) return;

        // Find middle
        int mid=(low+high)/2;

        // Sort left half
        mergeSortHelper(arr,low,mid);

        // Sort right half
        mergeSortHelper(arr,mid+1,high);

        // Merge both halves
        merge(arr,low,mid,high);
    }

    public int[] mergeSort(int[] nums) {
        // Start merge sort
        mergeSortHelper(nums,0,nums.length-1);
        return nums;
    }
}
