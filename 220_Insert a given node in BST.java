class Solution {
    private TreeNode solve(TreeNode root,int val) {
        if(root==null)return new TreeNode(val);

        if(val<root.data){
            root.left=solve(root.left,val);
        } else if(val>root.data){
            root.right=solve(root.right,val);
        }

        return root;
    }

    public TreeNode insertIntoBST(TreeNode root,int val) {
        return solve(root,val);
    }
}
