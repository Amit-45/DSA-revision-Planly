class Solution{
    private boolean possible(int[] nums,int day,int m,int k){
        int cnt=0,noOfB=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=day)cnt++; // Bloomed flower
            else{
                noOfB+=cnt/k; // Count bouquets from consecutive flowers
                cnt=0; // Break in adjacency
            }
        }
        noOfB+=cnt/k; // Count remaining flowers
        return noOfB>=m;
    }

    public int roseGarden(int n,int[] nums,int k,int m){
        if((long)m*k>n)return -1; // Not enough flowers

        int mini=Integer.MAX_VALUE,maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mini=Math.min(mini,nums[i]);
            maxi=Math.max(maxi,nums[i]);
        }

        int l=mini,h=maxi,ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(possible(nums,mid,m,k)){
                ans=mid;
                h=mid-1; // Possible: eliminate right half
            }
            else l=mid+1; // Not possible: eliminate left half
        }
        return ans;
    }
}
