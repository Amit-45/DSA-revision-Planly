UPDATE → COMPARE OLD & NEW → SMALLER: UP (PARENT → COMPARE → SWAP → REPEAT) | LARGER: DOWN (CHILDREN → SMALLEST → SWAP → REPEAT) → RESTORE MIN HEAP
---------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    private void heapifyUp(int[] arr,int ind) {
        int parent=(ind-1)/2; // FIND PARENT

        if(ind>0 && arr[ind]<arr[parent]) {
            swap(arr,ind,parent); // SWAP
            heapifyUp(arr,parent); // REPEAT UP
        }
    }

    private void heapifyDown(int[] arr,int ind) {
        int n=arr.length;
        int smallest=ind; // ASSUME SMALLEST

        int left=2*ind+1;
        int right=2*ind+2; // FIND CHILDREN

        if(left<n && arr[left]<arr[smallest])
            smallest=left; // CHECK LEFT

        if(right<n && arr[right]<arr[smallest])
            smallest=right; // CHECK RIGHT

        if(smallest!=ind) {
            swap(arr,ind,smallest); // SWAP
            heapifyDown(arr,smallest); // REPEAT DOWN
        }
    }

    private void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void heapify(int[] nums,int ind,int val) {
        if(nums[ind]>val) {
            nums[ind]=val; // UPDATE VALUE
            heapifyUp(nums,ind); // SMALLER → UP
        } else {
            nums[ind]=val; // UPDATE VALUE
            heapifyDown(nums,ind); // LARGER → DOWN
        }
    }
}
