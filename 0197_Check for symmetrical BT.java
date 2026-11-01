class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return symmetry(root.left,root.right);
    }

    private boolean symmetry(TreeNode left,TreeNode right) {
        if(left==null && right==null)return true;
        if(left==null || right==null)return false;
        if(left.data!=right.data)return false;

        return symmetry(left.left,right.right) &&
               symmetry(left.right,right.left);
    }
}
