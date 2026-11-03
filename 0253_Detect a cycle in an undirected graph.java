import java.util.*;
class Solution {

    private boolean dfs(int node,List<Integer> adj[],boolean[] visited,int parent) {

        // MARK VISITED
        visited[node]=true;

        // CHECK ALL NEIGHBOURS
        for(int neighbour:adj[node]) {

            // UNVISITED → DFS CALL (PARENT = CURRENT)
            if(!visited[neighbour]) {
                if(dfs(neighbour,adj,visited,node))
                    return true;
            }

            // VISITED + NOT PARENT → CYCLE
            else if(neighbour!=parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V,List<Integer> adj[]) {

        // CREATE VISITED
        boolean[] visited=new boolean[V];

        // TRAVERSE ALL NODES
        for(int i=0;i<V;i++) {

            // UNVISITED → DFS(i,-1)
            if(!visited[i]) {
                if(dfs(i,adj,visited,-1))
                    return true;
            }
        }

        // RETURN FALSE IF NO CYCLE
        return false;
    }
}
