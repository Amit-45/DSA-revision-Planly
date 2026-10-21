
class Solution{
    private int findFloor(int[] nums,int n,int x){
        int l=0,r=n-1;
        int ans=-1; //CAREFUL on THIS
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<=x){
                ans=nums[mid];
                l=mid+1;       // GO RIGHT  -> Possible floor candidate 
            }
            else{
                r=mid-1;       // GO LEFT -> Sorted array , so invalid for flooor
            }
        }
        return ans;
    }
    private int findCeil(int[] nums,int n,int x){
        int l=0,r=n-1;
        int ans=-1;   //CAREFUL HERE 
        while(l<=r){
            int mid=l+(r-l)/2;   
            if(nums[mid]>=x){
                ans=nums[mid];  //CAREFUL HERE -> rest all same code as Lower Bound
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int[] getFloorAndCeil(int[] nums,int x){
        int n=nums.length;
        int floor=findFloor(nums,n,x);
        int ceil=findCeil(nums,n,x);
        return new int[]{floor,ceil};
    }
}
