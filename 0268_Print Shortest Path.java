------------------------using prioroty queue-------------------------------
import java.util.*;

class Solution {
    public List<Integer> shortestPath(int n,int m,int[][] edges) {

        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] edge:edges) {
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i; // EACH NODE IS ITS OWN PARENT

        dist[1]=0;
        pq.add(new int[]{0,1});

        while(!pq.isEmpty()) {
            int[] curr=pq.poll();
            int dis=curr[0],node=curr[1];

            if(dis>dist[node]) continue;

            for(int[] it:adj.get(node)) {
                int adjNode=it[0],wt=it[1];

                if(dis+wt<dist[adjNode]) {
                    dist[adjNode]=dis+wt;
                    pq.add(new int[]{dist[adjNode],adjNode});

                    parent[adjNode]=node; // STORE PREVIOUS NODE
                }
            }
        }

        if(dist[n]==Integer.MAX_VALUE) return Arrays.asList(-1);

        List<Integer> path=new ArrayList<>();
        int node=n;

        while(parent[node]!=node) {
            path.add(node); // TRACE PATH BACKWARDS
            node=parent[node];
        }

        path.add(1);
        Collections.reverse(path); // SOURCE TO DESTINATION

        path.add(0,dist[n]); // ADD SHORTEST DISTANCE
        return path;
    }
}
