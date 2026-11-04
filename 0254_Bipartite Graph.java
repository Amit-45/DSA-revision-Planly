import java.util.*;
class Solution {
    private boolean bfs(int start,List<List<Integer>> adj,int[] color) {
        // CREATE QUEUE → COLOR START = 0
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        color[start]=0;

        // QUEUE NOT EMPTY → REMOVE NODE
        while(!q.isEmpty()) {
            int node=q.poll();

            // CHECK ALL NEIGHBOURS
            for(int it:adj.get(node)) {

                // UNCOLOURED → OPPOSITE COLOR + ENQUEUE
                if(color[it]==-1) {
                    color[it]=1-color[node];
                    q.offer(it);
                }

                // SAME COLOR → CONFLICT
                else if(color[it]==color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    // MAIN FUNCTION
    public boolean isBipartite(int V,List<List<Integer>> edges) {

        // CREATE COLOR ARRAY = -1
        int[] color=new int[V];
        Arrays.fill(color,-1);

        // BUILD ADJACENCY LIST
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }

        // READ EDGES → ADD BOTH DIRECTIONS
        for(List<Integer> edge:edges) {
            int u=edge.get(0),v=edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // TRAVERSE ALL NODES → HANDLE DISCONNECTED COMPONENTS
        for(int i=0;i<V;i++) {
            if(color[i]==-1) {

                // UNCOLOURED → BFS CALL
                if(!bfs(i,adj,color)) {
                    return false;
                }
            }
        }
        // ALL COMPONENTS PASSED
        return true;
    }
}
