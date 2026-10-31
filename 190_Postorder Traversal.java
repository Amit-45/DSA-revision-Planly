----------------RECURSIVE---------------------------------
class Solution {
    private void dfs(TreeNode root,List<Integer> ans){
        if(root==null)return;
        dfs(root.left,ans);
        dfs(root.right,ans);
        ans.add(root.data);
    }
    public List<Integer> postorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        dfs(root,ans);
        return ans;
    }
}
----------------ITERATIVE----------------------------------
class Solution {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root==null)return ans;
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            ans.add(root.data);
            if(root.left!=null)st.push(root.left);
            if(root.right!=null)st.push(root.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
