class Solution{
    private int countPartitions(int[] a,int maxSum){
        int partitions=1,subarraySum=0;
        for(int i=0;i<a.length;i++){
            if(subarraySum+a[i]<=maxSum){
                subarraySum+=a[i]; // Add to current subarray
            }
            else{
                partitions++; // Start a new subarray
                subarraySum=a[i];
            }
        }
        return partitions;
    }

    public int largestSubarraySumMinimized(int[] a,int k){
        int l=a[0],h=0;
        for(int i=0;i<a.length;i++){
            l=Math.max(l,a[i]); // Largest element
            h+=a[i]; // Total sum
        }

        while(l<=h){
            int mid=l+(h-l)/2;
            int partitions=countPartitions(a,mid);

            if(partitions>k)l=mid+1; // Too many partitions: increase limit
            else h=mid-1; // Possible: try smaller maximum sum
        }
        return l;
    }
}
