---------------------------------BFS-----------------------------------------------------------------------
BFS HELPER:   R → REMOVE → W → PRINT → A* → CHECK NEIGHBOURS → NOT VISITED: M* → MARK + ENQUEUE | VISITED: SKIP
BFS MAIN :   CREATE vis, ans, adj → INITIALIZE V EMPTY LISTS → READ EDGES → ADD BOTH DIRECTIONS → ALL NODES → UNVISITED: MARK + BFS CALL → RETURN ans
------------------------------------------------------------------------------------------------------------
IF ADJACENCY LIST : CREATE LIST → INITIALIZE V EMPTY LISTS → ADD EDGES → adj.get(node) → CHECK NEIGHBOURS
----------------------------------------------------------------------------------------------------------
import java.util.*;
class Solution {

    // R → REMOVE | W → WORK | A* → CHECK NEIGHBOURS
    private void bfs(int node,List<List<Integer>> adj,boolean[] vis,List<Integer> ans) {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            node=q.poll(); // R → REMOVE
            ans.add(node); // W → PRINT

            // A* → CHECK NEIGHBOURS
            for(int it:adj.get(node)) {
                if(!vis[it]) {
                    vis[it]=true; // M* → MARK
                    q.add(it); // NOT VISITED → ENQUEUE
                }
                // VISITED → SKIP
            }
        }
    }

    public List<Integer> bfsOfGraph(int V,List<List<Integer>> edges) {
        boolean[] vis=new boolean[V];
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();

        // CREATE V EMPTY LISTS
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());

        // ADD BOTH DIRECTIONS
        for(List<Integer> edge:edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        // ALL NODES → UNVISITED → MARK + BFS CALL
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                vis[i]=true;
                bfs(i,adj,vis,ans);
            }
        }

        return ans;
    }
}
------------------------------------------------------------------------------------------
IF ADJACENCY MATRIX : CREATE V×V MATRIX → ADD EDGES → LOOP ALL V NODES → adj[node][it]==1 → CHECK NEIGHBOURS
-------------------------------------------------------------------------------------------
import java.util.*;

class Solution {

    // R → REMOVE | W → WORK | A* → CHECK NEIGHBOURS
    private void bfs(int node,int[][] adj,boolean[] vis,List<Integer> ans) {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            node=q.poll(); // R → REMOVE
            ans.add(node); // W → PRINT

            // A* → CHECK ALL NODES IN MATRIX
            for(int it=0;it<adj.length;it++) {
                if(adj[node][it]==1 && !vis[it]) {
                    vis[it]=true; // M* → MARK
                    q.add(it); // NOT VISITED → ENQUEUE
                }
                // VISITED → SKIP
            }
        }
    }

    public List<Integer> bfsOfGraph(int V,List<List<Integer>> edges) {
        boolean[] vis=new boolean[V];
        List<Integer> ans=new ArrayList<>();

        // CREATE ADJACENCY MATRIX
        int[][] adj=new int[V][V];

        // READ EDGES → ADD BOTH DIRECTIONS
        for(List<Integer> edge:edges) {
            int u=edge.get(0),v=edge.get(1);
            adj[u][v]=1;
            adj[v][u]=1;
        }

        // ALL NODES → UNVISITED → MARK + BFS CALL
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                vis[i]=true;
                bfs(i,adj,vis,ans);
            }
        }

        return ans;
    }
}
