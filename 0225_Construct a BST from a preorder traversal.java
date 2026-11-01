Brute: Naively create the BST by inserting every preorder element one by one.
Better: BST inorder traversal is always sorted; use the same range-validation concept as Validate BST to build the tree from preorder.
Optimal: Use an index + upper bound; create the root, build LEFT with root.data as the new bound, and RIGHT with the old bound.
--------------------------------------Optimal----------------------------------------------------------
class Solution {
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        i=0;
        return build(preorder,Long.MAX_VALUE);
    }

    // CHECK BOUND → CREATE → LEFT → RIGHT
    private TreeNode build(int[] preorder,long bound) {
        if(i==preorder.length || preorder[i]>bound) return null;

        TreeNode root=new TreeNode(preorder[i++]);

        root.left=build(preorder,root.data); // LEFT → ROOT DATA
        root.right=build(preorder,bound);    // RIGHT → OLD BOUND

        return root;
    }
}
