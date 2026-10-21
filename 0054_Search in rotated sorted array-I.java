
class Solution{
    public int search(int[] a,int x){
        int l=0,r=a.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==x)return mid;
            // Check if left half is sorted
            if(a[l]<=a[mid]){
                // Check if x lies in left half
                if(a[l]<=x&&x<=a[mid])r=mid-1;
                else l=mid+1;
            }
            else{
                // Check if x lies in right half
                if(a[mid]<=x&&x<=a[r])l=mid+1;
                else r=mid-1;
            }
        }
        return -1;
    }
}
