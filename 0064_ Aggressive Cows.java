import java.util.Arrays;

class Solution{
    private boolean canWePlace(int[] nums,int dist,int cows){
        int cntCows=1;
        int last=nums[0]; // First cow at first stall

        for(int i=1;i<nums.length;i++){
            if(nums[i]-last>=dist){ // Check minimum distance
                cntCows++; // Place next cow
                last=nums[i]; // Update last placed stall
            }
            if(cntCows>=cows)return true; // All cows placed
        }
        return false; // Not enough stalls for all cows
    }

    public int aggressiveCows(int[] nums,int k){
        Arrays.sort(nums); // Sort stalls by position

        int l=1,h=nums[nums.length-1]-nums[0];
        while(l<=h){
            int mid=l+(h-l)/2; // Guess minimum distance
            if(canWePlace(nums,mid,k)){
                l=mid+1; // Possible: try a bigger distance
            }
            else h=mid-1; // Impossible: try a smaller distance
        }
        return h; // Maximum possible minimum distance
    }
}
