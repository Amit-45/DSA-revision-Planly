------------pseudo code ------------------------
1. merge() : sort two halves, add it back to array 
2. mergeHelper() : 
    -Find mid 
    -Sort LH
    -Sort RH
    -Merge both
3. mergeSort():
    mergeSortHelper(nums,0,n-1);
    return nums


-----------------merge()-----------------------------
AL temp
left,right -> low, mid+1
        while(both left and right in range){
            if left part ele < right part ele:
                add LEFT in temp -> LEFT ++
            else
                add RIGHT in temp -> right ++
        }
while(left<=mid) -> add LEFT in temp -> LEFT ++
while(right<=high) -> add RIGHT in temp -> right ++
    
// Copy sorted elements back: 
for(low to high): 
    a[i]=temp.get(i-low)



-----------------------------------------------------------------------
why i-low ???
-----------------------------------------------------------------------
Our array:
Index:   0   1   2   3   4   5   6   7
Value:  10  20  30  40  50  60  70  80

Merge sort working only on this portion:
Index:                       5   6   7
Value:                      60  70  80

so,
low=5;
high=7;

In temp array we need this:
0  1   2
60 70 80

5->convert to 0->  (i-low)   -> 5-5 =0
6-> convert to 1-> (i-low)   -> 6-5 =1
6-> convert to 1-> (i-low)   -> 7-5 =2

-----------------------CODE ---------------------------------


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
