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
