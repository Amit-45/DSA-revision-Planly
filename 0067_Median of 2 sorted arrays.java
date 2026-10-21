class Solution{
    public double median(int[] arr1,int[] arr2){
        int m=arr1.length,n=arr2.length;

        // Ensure arr1 is the smaller array
        if(m>n)return median(arr2,arr1);

        int size=m+n;
        int left=(m+n+1)/2;

        int l=0,h=m;
        while(l<=h){
            int mid1=l+(h-l)/2;
            int mid2=left-mid1;

            //Form the left half and try all possible cases for the left half 
            // l1 = last element of arr1's left half; if empty, use -infinity
            int l1=(mid1>0)?arr1[mid1-1]:Integer.MIN_VALUE;
            int r1=(mid1<m)?arr1[mid1]:Integer.MAX_VALUE;
            int l2=(mid2>0)?arr2[mid2-1]:Integer.MIN_VALUE;
            int r2=(mid2<n)?arr2[mid2]:Integer.MAX_VALUE;

            // Correct partition found (case of 3 from example)
            if(l1<=r2&&l2<=r1){
                if(size%2==1)return Math.max(l1,l2);
                else return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }

            // Too many elements taken from arr1 => try to take more from arr2
            else if(l1>r2)h=mid1-1;
            // Too few elements taken from arr1 => try to takr less from arr2 
            else l=mid1+1;
        }
        return 0;
    }
}
