class Solution{
    public int singleNonDuplicate(int[] a){
        int n=a.length;
        //EDGE CASES
        if(n==1)return a[0];
        if(a[0]!=a[1])return a[0];
        if(a[n-1]!=a[n-2])return a[n-1];
        int l=1,r=n-2;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]!=a[mid-1]&&a[mid]!=a[mid+1])return a[mid];   // Check if Mid is single element (left and right elem of mid are diff)
            if((mid%2==1&&a[mid]==a[mid-1])||(mid%2==0&&a[mid]==a[mid+1]))l=mid+1; //  If pair pattern (even,odd) rule is normal, ELIMINATE LEFT
            else r=mid-1;
        }
        return -1;
    }
}
