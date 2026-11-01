class Solution {
    // LEAF = LEFT NULL + RIGHT NULL
    private boolean isLeaf(TreeNode root) {
        return root.left==null && root.right==null;
    }

    // LEFT DOWN = PREFER LEFT, ELSE RIGHT, SKIP LEAF
    private void addLeft(TreeNode root,List<Integer> ans) {
        TreeNode curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr))ans.add(curr.data);
            if(curr.left!=null)curr=curr.left;
            else curr=curr.right;
        }
    }

    // LEAVES = ADD LEAF, ELSE LEFT → RIGHT
    private void addLeaves(TreeNode root,List<Integer> ans) {
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null)addLeaves(root.left,ans);
        if(root.right!=null)addLeaves(root.right,ans);
    }

    // RIGHT UP = PREFER RIGHT, ELSE LEFT, SKIP LEAF, REVERSE
    private void addRight(TreeNode root,List<Integer> ans) {
        TreeNode curr=root.right;
        List<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr))temp.add(curr.data);
            if(curr.right!=null)curr=curr.right;
            else curr=curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--)ans.add(temp.get(i));
    }

    // ROOT → LEFT → LEAVES → RIGHT
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        if(!isLeaf(root))ans.add(root.data);
        addLeft(root,ans);
        addLeaves(root,ans);
        addRight(root,ans);
        return ans;
    }
}
