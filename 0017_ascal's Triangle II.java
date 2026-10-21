class Solution {
   public int[] pascalTriangleII(int r) {
        int[] ans = new int[r]; 
        ans[0] = 1; 
        for(int i = 1; i < r; i++) {
            ans[i] = (ans[i-1] * (r - i)) / i;
        }
        return ans; 
    }
}
