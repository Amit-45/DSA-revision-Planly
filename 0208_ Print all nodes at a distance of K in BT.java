class Solution {
    public List<Integer> distanceK(TreeNode root,TreeNode target,int k) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;

        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root); // START FROM ROOT

        // PARENT MAP = BFS
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                parentMap.put(node.left,node); // LEFT → PARENT
                q.add(node.left);
            }
            if(node.right!=null){
                parentMap.put(node.right,node); // RIGHT → PARENT
                q.add(node.right);
            }
        }

        // START BFS FROM TARGET
        Set<TreeNode> visited=new HashSet<>();
        q.add(target);
        visited.add(target); // MARK VISITED
        int distance=0;

        while(!q.isEmpty()){
            if(distance==k){ // REACHED DISTANCE K
                while(!q.isEmpty())ans.add(q.poll().data);
                return ans;
            }

            int size=q.size(); // CURRENT LEVEL SIZE

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                // EXPLORE LEFT
                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }

                // EXPLORE RIGHT
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }

                // EXPLORE PARENT
                TreeNode parent=parentMap.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            distance++; // MOVE TO NEXT LEVEL
        }
        return ans;
    }
}
