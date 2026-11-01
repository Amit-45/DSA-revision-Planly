class Solution {
    public TreeNode lca(TreeNode root,int p,int q) {
        if(root==null)return null; // NULL = STOP

        // BOTH GREATER = RIGHT
        if(root.data<p && root.data<q)
            return lca(root.right,p,q);

        // BOTH SMALLER = LEFT
        if(root.data>p && root.data>q)
            return lca(root.left,p,q);

        // DIFFERENT SIDES OR EQUAL = LCA
        return root;
    }
}
