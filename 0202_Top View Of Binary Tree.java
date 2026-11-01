class Solution {
    static class Pair {
        TreeNode node;
        int line;
        Pair(TreeNode node,int line) {
            this.node=node;
            this.line=line;
        }
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;

        TreeMap<Integer,Integer> map=new TreeMap<>(); // SORT VERTICAL LINES
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0)); // ROOT = LINE 0

        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int line=p.line;

            if(!map.containsKey(line))map.put(line,node.data); // FIRST NODE = TOP VIEW

            if(node.left!=null)q.add(new Pair(node.left,line-1)); // LEFT = LINE - 1
            if(node.right!=null)q.add(new Pair(node.right,line+1)); // RIGHT = LINE + 1
        }

        ans.addAll(map.values()); // ASCENDING LINE ORDER
        return ans;
    }
}
