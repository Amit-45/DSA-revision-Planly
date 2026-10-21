
class Solution{
    public long Pow(int b,int exp,int M){
        long ans=1,base=b;
        while(exp>0){
            if(exp%2==1){
                ans*=base;
                if(ans>M)return M+1L;
            }
            exp>>=1;
            base*=base;
            if(base>M)base=M+1L;
        }
        return ans;
    }
    public int NthRoot(int N,int M){
        int l=1,h=M;
        while(l<=h){
            int mid=l+(h-l)/2;
            long midN=Pow(mid,N,M);
            if(midN==M)return mid;
            else if(midN<M)l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
}
