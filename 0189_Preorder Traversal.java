----------------------------RECURSIVE---------------------------------------------
class Solution {
    private void dfs(TreeNode root,List<Integer> ans){
        if(root==null)return;
        ans.add(root.data);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }
    public List<Integer> preorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        dfs(root,ans);
        return ans;
    }
}
--------------------------ITERATIVE------------------------------------------------
class Solution {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            ans.add(root.data);
            if(root.right!=null)st.push(root.right);
            if(root.left!=null)st.push(root.left);
        }
        return ans;
    }
}
