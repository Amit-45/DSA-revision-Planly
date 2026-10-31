------------RECURSIVE------------------------------------
class Solution {
    private void dfs(TreeNode root,List<Integer> ans){
        if(root==null)return;
        dfs(root.left,ans);
        ans.add(root.data);
        dfs(root.right,ans);
    }
    public List<Integer> inorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        dfs(root,ans);
        return ans;
    }
}
-----------ITERATIVE--------------------------------------
class Solution {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            ans.add(root.data);
            root=root.right;
        }
        return ans;
    }
}
  
