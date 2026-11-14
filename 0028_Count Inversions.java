NORMAL MERGE SORT                 COUNT INVERSIONS(Modified Merge Sort)

1. merge() :                      1. merge() :
   Sort two halves                   Sort two halves + Count inversions
   - Compare LH and RH               - Compare LH and RH
   - Take smaller element            - If arr[i] <= arr[j] -> Take left
   - Copy remaining elements         - If arr[i] > arr[j] -> Take right
   - Copy TEMP to MAIN ARRAY             count += (mid-i+1)
                                     - Copy remaining elements
                                     - Copy TEMP to MAIN ARRAY


2. mergeHelper() :                2. mergeHelper() :
   - Find mid                         - Find mid
   - Sort LH                          - Sort LH -> leftCount
   - Sort RH                          - Sort RH -> rightCount
   - Merge both                       - Merge both -> mergeCount
                                      - Total = leftCount + rightCount + mergeCount
                                      - Return total count


3. mergeSort() :                  3. mergeSort() :
   - mergeSortHelper(nums,0,n-1);     - return mergeSortHelper(nums,0,n-1);
   - return nums;


RETURN: Sorted Array              RETURN: Inversion Count

--------------------------CODE--------------------------------
class Solution {
    // 1. merge(): Compare + Count + Merge
    long merge(int[] a, int lo, int mid, int hi) {

        // Pointers: LH and RH
        int i=lo, j=mid+1;
        int[] temp=new int[hi-lo+1];
        int k=0;
        long count=0;

        // Compare LH and RH
        while(i<=mid && j<=hi) {

            // arr[i] <= arr[j] -> Take left
            if(a[i]<=a[j]) {
                temp[k++]=a[i++];
            }

            // arr[i] > arr[j] -> Take right + Count inversions
            else {
                count+=(mid-i+1);
                temp[k++]=a[j++];
            }
        }

        // Copy remaining elements
        while(i<=mid) temp[k++]=a[i++];
        while(j<=hi) temp[k++]=a[j++];

        // Copy TEMP to MAIN ARRAY
        for(int x=0;x<temp.length;x++) {
            a[lo+x]=temp[x];
        }

        return count;
    }

    // 2. mergeHelper(): Divide + Sort + Merge + Count
    long mergeHelper(int[] a, int lo, int hi) {

        // Base case
        if(lo>=hi) return 0;

        // Find mid
        int mid=(lo+hi)/2;

        // Sort LH -> leftCount
        long leftCount=mergeHelper(a,lo,mid);

        // Sort RH -> rightCount
        long rightCount=mergeHelper(a,mid+1,hi);

        // Merge both -> mergeCount
        long mergeCount=merge(a,lo,mid,hi);

        // Total = Left + Right + Merge
        return leftCount+rightCount+mergeCount;
    }

    // 3. numberOfInversions(): Return inversion count
    public long numberOfInversions(int[] nums) {

        // Call helper + Return total count
        return mergeHelper(nums,0,nums.length-1);
    }
}

    public long numberOfInversions(int[] nums) {
        return sortCount(nums, 0, nums.length - 1);
    }
}
