class Solution{
    public int kthElement(int[] arr1,int[] arr2,int k){
        int m=arr1.length,n=arr2.length;

        // Keep arr1 smaller for binary search
        if(m>n)return kthElement(arr2,arr1,k);

        // Left half must contain exactly k elements
        int l=Math.max(0,k-n),h=Math.min(k,m);

        while(l<=h){
            int mid1=l+(h-l)/2;
            int mid2=k-mid1;

            // Get left and right boundary elements
            int l1=(mid1>0)?arr1[mid1-1]:Integer.MIN_VALUE;
            int r1=(mid1<m)?arr1[mid1]:Integer.MAX_VALUE;
            int l2=(mid2>0)?arr2[mid2-1]:Integer.MIN_VALUE;
            int r2=(mid2<n)?arr2[mid2]:Integer.MAX_VALUE;

            // Check if the partition is correct
            if(l1<=r2&&l2<=r1)return Math.max(l1,l2);

            // Too many elements from arr1
            else if(l1>r2)h=mid1-1;

            // Too few elements from arr1
            else l=mid1+1;
        }
        return -1;
    }
}
