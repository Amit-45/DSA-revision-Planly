import java.util.*;

class Solution {

    // SOURCE → QUEUE → POLL → CHECK NEIGHBOURS → UPDATE → ENQUEUE
    private void bfs(int src,List<Integer>[] adj,int[] dist) {

        dist[src]=0; // SOURCE DISTANCE = 0

        Queue<Integer> q=new LinkedList<>();
        q.add(src); // ADD SOURCE TO QUEUE

        while(!q.isEmpty()) {
            int node=q.poll(); // POLL NODE

            for(int adjNode:adj[node]) { // TRAVERSE NEIGHBOURS

                // NEW DISTANCE = CURRENT DISTANCE + 1 → COMPARE → UPDATE
                if(dist[node]+1<dist[adjNode]) {
                    dist[adjNode]=dist[node]+1; // UPDATE DISTANCE
                    q.add(adjNode); // ENQUEUE NEIGHBOUR
                }
            }
        }
    }

    // CREATE GRAPH → INIT DISTANCE → CALL BFS → UNREACHABLE = -1 → RETURN
    public int[] shortestPath(int[][] edges,int N,int M) {

        // CREATE UNDIRECTED GRAPH → ADD BOTH DIRECTIONS
        List<Integer>[] adj=new ArrayList[N];
        for(int i=0;i<N;i++) adj[i]=new ArrayList<>();

        for(int[] edge:edges) {
            int u=edge[0];
            int v=edge[1];

            adj[u].add(v); // U → V
            adj[v].add(u); // V → U
        }

        // INIT DISTANCE → ALL INFINITY
        int[] dist=new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);

        // CALL BFS FROM SOURCE 0
        bfs(0,adj,dist);

        // UNREACHABLE NODES → INFINITY TO -1
        for(int i=0;i<N;i++) {
            if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        }

        return dist; // RETURN SHORTEST DISTANCES
    }
}
