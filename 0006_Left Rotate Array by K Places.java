--------------NOOB--------------------------------
class Solution {
    public void rotateArray(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int[] temp=new int[k];
        for(int i =0;i<k;i++){
            temp[i]=nums[i];
        }
        for(int i=k;i<n;i++){
            nums[i-k]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[n-k+i] = temp[i];
        }
    }
}
-------------OPTIMAL----------------------------
class Solution {
    private void reverse(int i, int j,int nums[]){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void rotateArray(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
        reverse(0,n-1,nums);
    }
}
