class BSTIterator {
    Stack<TreeNode> stack=new Stack<>();

    // CONSTRUCTOR → PUSH ROOT'S ENTIRE LEFT PATH
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    // STACK NOT EMPTY?
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // POP TOP → PUSH RIGHT CHILD'S LEFT PATH → RETURN DATA
    public int next() {
        TreeNode node=stack.pop();
        pushAll(node.right);
        return node.data;
    }

    // PUSH NODE → MOVE LEFT → REPEAT UNTIL NULL
    private void pushAll(TreeNode node) {
        while(node!=null) {
            stack.push(node);
            node=node.left;
        }
    }
}
