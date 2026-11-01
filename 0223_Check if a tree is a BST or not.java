class Solution {
    // ROOT = (-INF, +INF)
    public boolean isBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    // CHECK RANGE → SPLIT RANGE
    private boolean validate(TreeNode root,long min,long max) {
        if(root==null)return true; // NULL = VALID

        if(root.data<=min || root.data>=max)return false; // INVALID = FALSE

        // LEFT: MAX = ROOT | RIGHT: MIN = ROOT
        return validate(root.left,min,root.data) &&
               validate(root.right,root.data,max);
    }
}
