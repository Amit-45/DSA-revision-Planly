class Solution{
    private int maxOfArray(int[] nums){
        int maxi=Integer.MIN_VALUE; // max function to set Upper Range of Binary search 
        int n=nums.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]); 
        }
        return maxi;
    }

    private long calculateTotalHours(int[] nums,int hourly){
        long totalH=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            totalH+=(nums[i]+hourly-1)/hourly; // DIVSION AND ADDING
        }
        return totalH;
    }

    public int minimumRateToEatBananas(int[] nums,int h){
        int l=1;
        int r=maxOfArray(nums); 
        while(l<=r){
            int mid=l+(r-l)/2;
            long totalHours=calculateTotalHours(nums,mid);
            if(totalHours<=h){
                r=mid-1; // Valid: eliminate right half, search left for smaller speed
            }
            else{
                l=mid+1; // Invalid: eliminate left half, search right for higher speed
            }
        }
        return l;
    }
}
