class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if(root==null || root==p || root==q)return root; // BASE CASE

        TreeNode left=lowestCommonAncestor(root.left,p,q); // SEARCH LEFT
        TreeNode right=lowestCommonAncestor(root.right,p,q); // SEARCH RIGHT

        if(left!=null && right!=null)return root; // BOTH FOUND = LCA
        if(left!=null)return left; // LEFT FOUND
        return right; // RIGHT FOUND
    }
}
