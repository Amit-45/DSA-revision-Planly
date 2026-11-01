class Solution {
    public TreeNode searchBST(TreeNode root,int val) {
        while(root!=null && root.data!=val){
            root=root.data>val?root.left:root.right;
        }
        return root;
    }
}
