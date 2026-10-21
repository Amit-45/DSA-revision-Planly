class Solution{
    private int lowerBound(int[] arr,int n,int x){
        int l=0,h=n-1,ans=n;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]>=x){
                ans=mid; // First 1 may be here; search left
                h=mid-1;
            }
            else l=mid+1; // 0 found; search right
        }
        return ans;
    }

    public int rowWithMax1s(int[][] mat){
        int n=mat.length,m=mat[0].length;
        int cnt_max=0,index=-1;

        // Traverse each row
        for(int i=0;i<n;i++){
            // Count 1s using columns - first 1 index
            int cnt_ones=m-lowerBound(mat[i],m,1);

            // Update row if it has more 1s
            if(cnt_ones>cnt_max){
                cnt_max=cnt_ones;
                index=i;
            }
        }
        // Return row index, or -1 if no 1 exists
        return index;
    }
}
