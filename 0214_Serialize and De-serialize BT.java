class Solution {
    // serialize: TREE → STRING
    public String serialize(TreeNode root) {
        if(root==null)return "";

        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root); // START BFS

        while(!q.isEmpty()){
            TreeNode node=q.poll(); // POLL NODE

            if(node==null){
                sb.append("#,"); // NULL = #
            } else {
                sb.append(node.data).append(","); // APPEND VALUE
                q.offer(node.left); // PUSH LEFT
                q.offer(node.right); // PUSH RIGHT
            }
        }
        return sb.toString();
    }

    // deserialization : STRING → TREE
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;

        String[] values=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0])); // FIRST VALUE = ROOT

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root); // START BFS

        int i=1;
        while(!q.isEmpty()){
            TreeNode node=q.poll(); // POLL PARENT

            // READ LEFT CHILD
            if(!values[i].equals("#")){
                node.left=new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.left); // ADD LEFT TO QUEUE
            }
            i++;

            // READ RIGHT CHILD
            if(!values[i].equals("#")){
                node.right=new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.right); // ADD RIGHT TO QUEUE
            }
            i++;
        }
        return root;
    }
}
