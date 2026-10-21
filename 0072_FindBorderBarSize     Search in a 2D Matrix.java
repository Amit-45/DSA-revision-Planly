class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        
        int n=mat.length;  // row
        int m= mat[0].length;  //col
        
        int l=0;
        int r=n*m-1;

        while(l<=r)
        {
            int mid=l+(r-l)/2;

            //1D index-> 2D coordinates
            int row=mid/m;
            int col=mid%m;

            

            if(mat[row][col]==target)
            {
                return true;
            }
            else if((mat[row][col] < target))
            {
                l = mid + 1;
            }
            else 
            {
                r = mid -1;
            }
        }
        return false;
    }
}
   
    

 
