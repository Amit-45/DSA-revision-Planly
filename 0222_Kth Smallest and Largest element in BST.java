class Solution {
    int k,result;

    // LEFT → ROOT → RIGHT
    private void inorder(TreeNode root) {
        if(root==null)return;
        inorder(root.left);
        if(--k==0){
            result=root.data;
            return;
        }
        inorder(root.right);
    }

    // RIGHT → ROOT → LEFT
    private void reverseInorder(TreeNode root) {
        if(root==null)return;
        reverseInorder(root.right);
        if(--k==0){
            result=root.data;
            return;
        }
        reverseInorder(root.left);
    }

    public List<Integer> kLargesSmall(TreeNode root,int k) {
        this.k=k;
        result=-1;
        inorder(root);
        int smallest=result;

        this.k=k;
        result=-1;
        reverseInorder(root);
        int largest=result;

        return Arrays.asList(smallest,largest);
    }
}
