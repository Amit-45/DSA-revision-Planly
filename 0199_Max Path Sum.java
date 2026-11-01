class Solution {
    int maxi=Integer.MIN_VALUE;
    private int dfs(TreeNode root) {
        if(root==null)return 0;
        int left=Math.max(0,dfs(root.left));
        int right=Math.max(0,dfs(root.right));
        maxi=Math.max(maxi,left+right+root.data);
        return root.data+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        maxi=Integer.MIN_VALUE;
        dfs(root);
        return maxi;
    }
}
