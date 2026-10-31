class NodeState {
    TreeNode node;
    int state;
    NodeState(TreeNode node,int state){
        this.node=node;
        this.state=state;
    }
}
class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        if(root==null)return Arrays.asList(in,pre,post);
        Stack<NodeState> st=new Stack<>();
        st.push(new NodeState(root,1));
        while(!st.isEmpty()){
            NodeState top=st.pop();
            TreeNode node=top.node;
            if(top.state==1){
                pre.add(node.data);
                st.push(new NodeState(node,2));
                if(node.left!=null)st.push(new NodeState(node.left,1));
            }
            else if(top.state==2){
                in.add(node.data);
                st.push(new NodeState(node,3));
                if(node.right!=null)st.push(new NodeState(node.right,1));
            }
            else{
                post.add(node.data);
            }
        }
        return Arrays.asList(in,pre,post);
    }
}
