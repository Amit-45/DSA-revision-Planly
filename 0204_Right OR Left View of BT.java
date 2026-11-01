class Solution {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        left(root,0,res);
        return res;
    }

    private void left(TreeNode root,int level,List<Integer> res) {
        if(root==null)return;
        if(res.size()==level)res.add(root.data);
        left(root.left,level+1,res);
        left(root.right,level+1,res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        right(root,0,res);
        return res;
    }

    private void right(TreeNode root,int level,List<Integer> res) {
        if(root==null)return;
        if(res.size()==level)res.add(root.data);
        right(root.right,level+1,res);
        right(root.left,level+1,res);
    }
}
