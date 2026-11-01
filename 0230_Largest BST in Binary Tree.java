class Solution {
    class NodeValue {
        int minNode,maxNode,maxSize;

        NodeValue(int min,int max,int size) {
            minNode=min;
            maxNode=max;
            maxSize=size;
        }
    }

    private NodeValue solve(TreeNode root) {
        if(root==null)
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0); // NULL → MIN=MAX, MAX=MIN

        NodeValue left=solve(root.left);
        NodeValue right=solve(root.right); // POSTORDER → LEFT + RIGHT FIRST

        // CHECK BST → LEFT MAX < ROOT < RIGHT MIN
        if(left.maxNode<root.data && root.data<right.minNode) {
            return new NodeValue(
                Math.min(root.data,left.minNode), // SUBTREE MIN
                Math.max(root.data,right.maxNode), // SUBTREE MAX
                left.maxSize+right.maxSize+1 // COMBINE SIZES
            );
        }

        // INVALID BST → CARRY LARGEST CHILD SIZE
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,
            Math.max(left.maxSize,right.maxSize));
    }

    public int largestBST(TreeNode root) {
        return solve(root).maxSize;
    }
}
