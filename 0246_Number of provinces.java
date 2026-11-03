import java.util.*;
class Solution {
    public int numProvinces(int[][] adj) { //adjacency matrix already given, so no need to build Graph
        int V=adj.length;
        boolean[] vis=new boolean[V];
        int count=0;

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }

    // DFS recursive call
    private void dfs(int node,int[][] adj,boolean[] vis) {
        vis[node]=true;
        for(int j=0;j<adj.length;j++) { 
            if(adj[node][j]==1 && !vis[j]) {      //MATRIX → adj[node][j]==1
                dfs(j,adj,vis);
            }
        }
    }
}
