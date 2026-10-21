
class Solution{
    public int lowerBound(int[] nums,int x){
        int n=nums.length;
        int l=0,r=n-1,ans=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>=x){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    public int upperBound(int[] nums,int x){
        int n=nums.length;
        int l=0,r=n-1,ans=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]>x){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums,int target){
        int n=nums.length;
        int lb=lowerBound(nums,target);
        if(lb==n||nums[lb]!=target)return new int[]{-1,-1}; //IMPORTANT 2 CONDTIONS ADDED 
        int ub=upperBound(nums,target); 
        return new int[]{lb,ub-1};
    }
}
