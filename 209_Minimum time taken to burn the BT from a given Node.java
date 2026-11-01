class Solution {
    public int timeToBurnTree(TreeNode root,int start) {
        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        TreeNode target=bfsToMapParents(root,parentMap,start); // PARENT MAP + FIND TARGET
        return findMaxDistance(parentMap,target); // BFS FROM TARGET
    }

    private TreeNode bfsToMapParents(TreeNode root,Map<TreeNode,TreeNode> parentMap,int start) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode target=null;

        while(!q.isEmpty()){
            TreeNode node=q.poll();

            if(node.data==start)target=node; // FIND TARGET

            if(node.left!=null){
                parentMap.put(node.left,node); // LEFT → PARENT
                q.add(node.left);
            }
            if(node.right!=null){
                parentMap.put(node.right,node); // RIGHT → PARENT
                q.add(node.right);
            }
        }
        return target;
    }

    private int findMaxDistance(Map<TreeNode,TreeNode> parentMap,TreeNode target) {
        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        q.add(target);
        visited.add(target); // MARK TARGET VISITED

        int time=0;

        while(!q.isEmpty()){
            int size=q.size();
            boolean burned=false;

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                    burned=true;
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                    burned=true;
                }

                TreeNode parent=parentMap.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                    burned=true;
                }
            }

            if(burned)time++; // COUNT BURNING TIME
        }
        return time;
    }
}
