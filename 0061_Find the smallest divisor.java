class Solution{
    public int smallestDivisor(int[] a,int threshold){
        int l=1,h=0;
        for(int x:a)h=Math.max(h,x);
        int ans=h;
        while(l<=h){
            int mid=l+(h-l)/2;
            int sum=0;
            for(int x:a)sum+=(x+mid-1)/mid;
            if(sum<=threshold){
                ans=mid;
                h=mid-1; // Valid, need smaller divisor, eliminate right
            }
            else l=mid+1; // Invalid, need larger divisor, eliminate left
        }
        return l;
    }
}
