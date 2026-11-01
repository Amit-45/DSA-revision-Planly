class Solution {
    // NO LEFT = RIGHT | NO RIGHT = LEFT | BOTH = CONNECT
    private TreeNode connector(TreeNode root) {
        if(root.left==null)return root.right;
        if(root.right==null)return root.left;

        TreeNode leftChild=root.left;
        TreeNode rightChild=root.right;

        while(rightChild.left!=null){
            rightChild=rightChild.left;
        }

        rightChild.left=leftChild;
        return root.right;
    }

    // SEARCH → CONNECT → UPDATE POINTER
    public TreeNode deleteNode(TreeNode root,int key) {
        if(root==null)return null;
        if(root.data==key)return connector(root);

        TreeNode node=root;

        while(node!=null){
            if(node.data>key){
                if(node.left!=null && node.left.data==key){
                    node.left=connector(node.left);
                    break;
                } else {
                    node=node.left;
                }
            } else {
                if(node.right!=null && node.right.data==key){
                    node.right=connector(node.right);
                    break;
                } else {
                    node=node.right;
                }
            }
        }
        return root;
    }
}
