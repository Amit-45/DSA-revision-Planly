
class Solution{
    public int floorSqrt(int n){
        int l=1,r=n;
        long ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            long val=1L*mid*mid;
            if(val<=n){
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return (int)ans;
    }
}
