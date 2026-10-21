class Solution{
    public int findMin(ArrayList<Integer> arr){
        //TRICK TO REMOVE ARRAY LIST  :IGNORE THIS
        int[] a=new int[arr.size()];
        for(int i=0;i<arr.size();i++)a[i]=arr.get(i);



        int l=0,r=a.length-1,ans=Integer.MAX_VALUE;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[l]<=a[mid]){
                ans=Math.min(ans,a[l]);
                l=mid+1;
            }
            else{
                ans=Math.min(ans,a[mid]);
                r=mid-1;
            }
        }
        return ans;
    }
}
