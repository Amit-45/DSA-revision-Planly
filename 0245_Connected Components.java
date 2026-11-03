1 DFS call on an unvisited node of any Connected component explores all the members of that connected component and marks as VISITED 
------------------------------------------------------------------------------------------------------
class Solution {
    public int findNumberOfComponent(int V,List<List<Integer>> edges) {
        boolean[] vis=new boolean[V];
        List<List<Integer>> adj=new ArrayList<>(); //adjacency list 
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());

        //build graph
        for(List<Integer> edge:edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        int count=0;
        for(int i=0;i<V;i++) {                                 
            if(!vis[i]) {   //if visited -> skip
                count++; //unvisted node -> increase count
                dfs(i,adj,vis);
            }
        }
        return count;
    }


    //recursive DFS function
    private void dfs(int node,List<List<Integer>> adj,boolean[] vis) {
        vis[node]=true;
        for(int it:adj.get(node)) {      //LIST: adj.get(node)
            if(!vis[it])dfs(it,adj,vis);
        }
    }
}
