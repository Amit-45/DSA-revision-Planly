----------------------------BRUTE-------------------------------------
class Solution {
    private int height(TreeNode root) {
        if(root==null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int left=height(root.left);
        int right=height(root.right);
        int current=left+right;
        int leftDiameter=diameterOfBinaryTree(root.left);
        int rightDiameter=diameterOfBinaryTree(root.right);
        return Math.max(current,Math.max(leftDiameter,rightDiameter));
    }
}
------------------------OPTIMAL--------------------------------------
class Solution {
    int diameter=0;
    private int height(TreeNode root) {
        if(root==null)return 0;
        int left=height(root.left);
        int right=height(root.right);
        diameter=Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter=0;
        height(root);
        return diameter;
    }
}
