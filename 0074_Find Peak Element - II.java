class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int l=0,h=m-1;

        while(l<=h) {
            int mid=l+(h-l)/2;
            int max=Integer.MIN_VALUE;
            int index=-1;

            // Find the maximum element in the middle column
            for(int i=0;i<n;i++) {
                if(mat[i][mid]>max) {
                    max=mat[i][mid];
                    index=i;
                }
            }

            // Get the left neighbour; if out of bounds, consider it as -1
            int left=mid-1>=0?mat[index][mid-1]:-1;
            int right=mid+1<m?mat[index][mid+1]:-1;

            // If the maximum is greater than both neighbours, peak found
            if(max>left && max>right)
                return new int[]{index,mid};

            // If the right neighbour is greater, eliminate the left half
            else if(max<right)
                l=mid+1;

            // If the left neighbour is greater, eliminate the right half
            else
                h=mid-1;
        }

        return new int[]{-1,-1};
    }
}
