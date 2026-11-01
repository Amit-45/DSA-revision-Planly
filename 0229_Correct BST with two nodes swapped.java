------------------------------OPTIMAL (Check violations method)------------------------------------
class Solution {
    TreeNode first=null,middle=null,last=null,prev=null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // NON-ADJACENT → SWAP FIRST + LAST
        if(last!=null)swap(first,last);

        // ADJACENT → SWAP FIRST + MIDDLE
        else swap(first,middle);
    }

    private void inorder(TreeNode root) {
        if(root==null)return;

        inorder(root.left);

        // VIOLATION → PREV > CURRENT
        if(prev!=null && prev.data>root.data) {
            if(first==null) {
                first=prev; // FIRST MISPLACED
                middle=root; // ADJACENT CASE
            } else {
                last=root; // SECOND VIOLATION
            }
        }

        prev=root;
        inorder(root.right);
    }

    // SWAP NODE VALUES
    private void swap(TreeNode a,TreeNode b) {
        int temp=a.data;
        a.data=b.data;
        b.data=temp;
    }
}
