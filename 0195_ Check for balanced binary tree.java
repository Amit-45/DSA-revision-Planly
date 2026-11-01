---------BRUTE--------------
  class Solution {
    int height(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
------OPTIMAL--------------
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root)!=-1;
    }
    private int dfsHeight(TreeNode root) {
        if(root==null)return 0;
        int leftHeight=dfsHeight(root.left);
        if(leftHeight==-1)return -1;
        int rightHeight=dfsHeight(root.right);
        if(rightHeight==-1)return -1;
        if(Math.abs(leftHeight-rightHeight)>1)return -1;
        return 1+Math.max(leftHeight,rightHeight);
    }
}
