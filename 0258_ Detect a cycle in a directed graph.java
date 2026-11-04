import java.util.*;

class Solution {
    private boolean dfs(int node,List<List<Integer>> adj,boolean[] vis,boolean[] pathVisited) {
        // MARK VISITED + CURRENT PATH
        vis[node]=true;
        pathVisited[node]=true;

        // CHECK NEIGHBOURS
        for(int it:adj.get(node)) {
            // ALREADY IN CURRENT PATH → CYCLE
            if(pathVisited[it]) return true;

            // UNVISITED → DFS CALL
            else if(!vis[it]) {
                if(dfs(it,adj,vis,pathVisited)) return true;
            }
        }

        // BACKTRACK → REMOVE FROM CURRENT PATH
        pathVisited[node]=false;

        return false;
    }

    public boolean isCyclic(int V,List<List<Integer>> adj) {
        // CREATE VISITED + PATH VISITED ARRAYS
        boolean[] vis=new boolean[V];
        boolean[] pathVisited=new boolean[V];

        // TRAVERSE ALL COMPONENTS
        for(int i=0;i<V;i++) {
            // UNVISITED → DFS CALL
            if(!vis[i]) {
                if(dfs(i,adj,vis,pathVisited)) return true;
            }
        }

        // NO CYCLE FOUND
        return false;
    }
}
