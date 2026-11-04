--------------------------------Using DFS----------------------------------------------------------------
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
-----------------------------USE BFS (TOPO SORT<V)-----------------------------------------------------
import java.util.*;

class Solution {

    private List<Integer> topoSort(int V,List<List<Integer>> adj) {
        // CREATE ANSWER + INDEGREE
        List<Integer> ans=new ArrayList<>();
        int[] inDegree=new int[V];

        // CALCULATE INDEGREE
        for(int i=0;i<V;i++) {
            for(int it:adj.get(i)) {
                inDegree[it]++;
            }
        }

        // CREATE QUEUE + ADD ZERO INDEGREE NODES
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(inDegree[i]==0) q.add(i);
        }

        // PROCESS QUEUE
        while(!q.isEmpty()) {
            // POLL NODE + ADD TO ANSWER
            int node=q.poll();
            ans.add(node);

            // DECREASE NEIGHBOURS' INDEGREE
            for(int it:adj.get(node)) {
                inDegree[it]--;

                // ZERO INDEGREE → ENQUEUE
                if(inDegree[it]==0) q.add(it);
            }
        }

        // RETURN TOPOLOGICAL ORDER
        return ans;
    }

    public boolean isCyclic(int V,List<List<Integer>> adj) {
        // CALL TOPOSORT
        List<Integer> topo=topoSort(V,adj);

        // SIZE < V → CYCLE
        if(topo.size()<V) return true;

        // ALL NODES PROCESSED → NO CYCLE
        return false;
    }
}
