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




class Solution {

    long sortCount(int[] a, int lo, int hi) {

        // if lo >= hi: return 0
        if (lo >= hi) return 0;

        // mid = (lo + hi) / 2
        int mid = (lo + hi) / 2;

        // count = left + right
        long count = sortCount(a, lo, mid) + sortCount(a, mid + 1, hi);

        // while merging halves
        int i = lo, j = mid + 1;
        int[] temp = new int[hi - lo + 1];
        int k = 0;

        while (i <= mid && j <= hi) {

            // if a[i] <= a[j]: take a[i++]
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            }

            // else: count += mid-i+1; take a[j++]
            else {
                count += mid - i + 1;
                temp[k++] = a[j++];
            }
        }

        // copy remaining elements
        while (i <= mid) temp[k++] = a[i++];
        while (j <= hi) temp[k++] = a[j++];

        // copy merged range back
        for (int x = 0; x < temp.length; x++)
            a[lo + x] = temp[x];

        return count;
    }

    public long numberOfInversions(int[] nums) {
        return sortCount(nums, 0, nums.length - 1);
    }
}
