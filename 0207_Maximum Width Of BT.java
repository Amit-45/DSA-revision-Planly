class Solution {
    static class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node,int index) {
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;

        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0)); // ROOT = INDEX 0

        while(!q.isEmpty()){
            int size=q.size(); // CURRENT LEVEL SIZE
            int min=q.peek().index; // FIRST INDEX
            int first=0,last=0;

            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode node=p.node;
                int cur=p.index-min; // NORMALIZE INDEX

                if(i==0)first=cur; // FIRST POSITION
                if(i==size-1)last=cur; // LAST POSITION

                if(node.left!=null)q.add(new Pair(node.left,2*cur+1)); // LEFT INDEX
                if(node.right!=null)q.add(new Pair(node.right,2*cur+2)); // RIGHT INDEX
            }
            ans=Math.max(ans,last-first+1); // UPDATE MAX WIDTH
        }
        return ans;
    }
}
