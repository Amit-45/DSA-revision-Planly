class Solution{
    public int findPeakElement(int[] arr){
        int n=arr.length;

        // Edge cases
        if(n==1)return 0;
        if(arr[0]>arr[1])return 0;
        if(arr[n-1]>arr[n-2])return n-1;

        int l=1,h=n-2;
        while(l<=h){
            int mid=l+(h-l)/2;

            // If mid is greater than both neighbours, peak found
            if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])return mid;

            // If right neighbour is greater, peak is on right; eliminate left half
            if(arr[mid+1]>arr[mid])l=mid+1;

            // Otherwise, peak is on left; eliminate right half
            else h=mid-1;
        }
        return -1;
    }
}
