class Solution {
    // FIND SMALLEST CHILD → SWAP → REPEAT DOWN
    private void heapifyDown(int[] arr,int ind) {
        int n=arr.length;
        int smallest=ind; // ASSUME CURRENT SMALLEST

        int left=2*ind+1;
        int right=2*ind+2; // FIND CHILDREN

        if(left<n && arr[left]<arr[smallest])
            smallest=left;

        if(right<n && arr[right]<arr[smallest])
            smallest=right;

        if(smallest!=ind) {
            swap(arr,ind,smallest); // SWAP WITH SMALLEST
            heapifyDown(arr,smallest); // MOVE DOWN
        }
    }

    // LAST NON-LEAF → BACKWARD → HEAPIFY DOWN
    public void buildMinHeap(int[] nums) {
        int n=nums.length;

        for(int i=n/2-1;i>=0;i--)
            heapifyDown(nums,i); // HEAPIFY EACH PARENT
    }

    private void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
