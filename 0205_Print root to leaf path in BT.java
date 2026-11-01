class Solution {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> allPaths=new ArrayList<>(); // STORE ALL PATHS
        List<Integer> path=new ArrayList<>(); // CURRENT PATH
        dfs(root,path,allPaths);
        return allPaths;
    }

    private void dfs(TreeNode node,List<Integer> path,List<List<Integer>> allPaths) {
        if(node==null)return; // NULL = STOP

        path.add(node.data); // ADD CURRENT NODE

        if(node.left==null && node.right==null) {
            allPaths.add(new ArrayList<>(path)); // LEAF = SAVE COPY
        } else {
            dfs(node.left,path,allPaths); // EXPLORE LEFT
            dfs(node.right,path,allPaths); // EXPLORE RIGHT
        }

        path.remove(path.size()-1); // BACKTRACK = REMOVE LAST NODE
    }
}
