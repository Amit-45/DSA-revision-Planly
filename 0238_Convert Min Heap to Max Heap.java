class Solution {
    // COMPARE CHILDREN → LARGEST → SWAP → REPEAT DOWN
    private void heapifyDown(int[] arr,int ind) {
        int n=arr.length,largest=ind;
        int left=2*ind+1,right=2*ind+2;

        if(left<n && arr[left]>arr[largest])largest=left;
        if(right<n && arr[right]>arr[largest])largest=right;

        if(largest!=ind) {
            swap(arr,ind,largest);
            heapifyDown(arr,largest);
        }
    }

    // LAST NON-LEAF → BACKWARD → HEAPIFY DOWN
    public int[] minToMaxHeap(int[] nums) {
        for(int i=nums.length/2-1;i>=0;i--)
            heapifyDown(nums,i);

        return nums;
    }

    private void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
