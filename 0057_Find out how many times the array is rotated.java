class Solution{
    public int findKRotation(ArrayList<Integer> arr){
        //TRICK TO REMOVE ARRAY LIST  :IGNORE THIS
        int[] a=new int[arr.size()];
        for(int i=0;i<arr.size();i++)a[i]=arr.get(i);



        int l=0,r=a.length-1,ans=Integer.MAX_VALUE,idx=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[l]<=a[mid]){
                if(a[l]<ans){
                    ans=a[l];
                    idx=l;
                }
                l=mid+1;
            }
            else{
                if(a[mid]<ans){
                    ans=a[mid];
                    idx=mid;
                }
                r=mid-1;
            }
        }
        return idx;
    }
}
