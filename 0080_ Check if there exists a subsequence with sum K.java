
class Solution {
    public boolean checkSubsequenceSum(int[] nums,int target) {
        return solve(0,nums.length,nums,target);
    }

    public boolean solve(int i,int n,int[] arr,int k) {
        // 1. When should I stop successfully? Target becomes 0
        if(k==0)return true;

        // 2. If target becomes negative, this path fails
        if(k<0)return false;

        // 3. If all elements are processed, no solution was found
        if(i==n)return false;

        // 4. First, take the current element
        if(solve(i+1,n,arr,k-arr[i]))return true;

        // 5. If taking fails, skip the current element
        return solve(i+1,n,arr,k);
    }
}
