class Solution {
    private int upperBound(int[] arr,int x,int m) {
        int low=0,high=m-1;
        int ans=m;

        // Find the first element greater than x
        while(low<=high) {
            int mid=low+(high-low)/2;

            if(arr[mid]>x) {
                ans=mid; // Possible upper bound found
                high=mid-1; // Search for a smaller upper bound
            } else {
                low=mid+1; // Search on the right
            }
        }

        return ans;
    }

    private int countSmallEqual(int[][] matrix,int n,int m,int x) {
        int cnt=0;

        // Count elements <= x in every row
        for(int i=0;i<n;i++) {
            cnt+=upperBound(matrix[i],x,m);
        }

        return cnt;
    }

    public int findMedian(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;

        // Find the minimum and maximum values in the matrix
        for(int i=0;i<n;i++) {
            low=Math.min(low,matrix[i][0]);
            high=Math.max(high,matrix[i][m-1]);
        }

        // Required median position
        int req=(n*m)/2;

        // Binary search on the answer
        while(low<=high) {
            int mid=low+(high-low)/2;

            // Count elements <= mid
            int smallEqual=countSmallEqual(matrix,n,m,mid);

            if(smallEqual<=req)
                low=mid+1; // Too few elements, search right
            else
                high=mid-1; // Enough elements, search left
        }

        return low;
    }
}
