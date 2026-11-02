class Solution {
    // COMPARE CHILDREN → LARGEST → SWAP → REPEAT DOWN
    private void heapifyDown(int[] arr,int last,int ind) {
        int largest=ind;
        int left=2*ind+1,right=2*ind+2;

        if(left<=last && arr[left]>arr[largest])largest=left;
        if(right<=last && arr[right]>arr[largest])largest=right;

        if(largest!=ind) {
            swap(arr,ind,largest);
            heapifyDown(arr,last,largest);
        }
    }

    // LAST NON-LEAF → BACKWARD → HEAPIFY DOWN
    private void buildMaxHeap(int[] nums) {
        for(int i=nums.length/2-1;i>=0;i--)
            heapifyDown(nums,nums.length-1,i);
    }

    // BUILD → ROOT/LAST SWAP → REDUCE → HEAPIFY DOWN
    public void heapSort(int[] nums) {
        buildMaxHeap(nums);

        int last=nums.length-1;
        while(last>0) {
            swap(nums,0,last);
            last--;
            heapifyDown(nums,last,0);
        }
    }

    private void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
