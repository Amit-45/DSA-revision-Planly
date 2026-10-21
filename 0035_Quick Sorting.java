class Solution {
    public int partition(int[] arr,int low,int high) {
        int pivot=arr[low];
        int i=low;
        int j=high;

        while(i<j) {
            while(arr[i]<=pivot && i<=high-1) {
                i++;
            }

            while(arr[j]>pivot && j>=low+1) {
                j--;
            }

            if(i<j) {
                swap(arr,i,j);
            }
        }

        swap(arr,low,j);
        return j;
    }

    public void quickSortHelper(int[] arr,int low,int high) {
        if(low<high) {
            int pIndex=partition(arr,low,high);

            quickSortHelper(arr,low,pIndex-1);
            quickSortHelper(arr,pIndex+1,high);
        }
    }

    public int[] quickSort(int[] nums) {
        quickSortHelper(nums,0,nums.length-1);
        return nums;
    }

    private void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
