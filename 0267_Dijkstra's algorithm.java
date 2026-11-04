---------------------------Using MinHeap(Prority Queue)-----------------------------------------------
import java.util.*;

class Solution {
    public int[] dijkstra(int V,ArrayList<ArrayList<Integer>> edges,int S) {

        ArrayList<ArrayList<int[]>> adj=new ArrayList<>(); // CREATE GRAPH
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(ArrayList<Integer> e:edges) {
            int u=e.get(0),v=e.get(1),wt=e.get(2);
            adj.get(u).add(new int[]{v,wt}); // ADD EDGE
            adj.get(v).add(new int[]{u,wt}); // UNDIRECTED EDGE
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]); // MIN HEAP

        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9); // INITIALIZE INFINITY

        dist[S]=0; // SOURCE DISTANCE
        pq.add(new int[]{0,S}); // ADD SOURCE

        while(!pq.isEmpty()) {
            int[] curr=pq.poll(); // POLL MINIMUM PAIR
            int dis=curr[0],node=curr[1];

            if(dis>dist[node]) continue; // SKIP STALE ENTRY

            for(int[] it:adj.get(node)) { // TRAVERSE NEIGHBOURS
                int adjNode=it[0],edgeWt=it[1];

                if(dis+edgeWt<dist[adjNode]) { // EDGE RELAXATION
                    dist[adjNode]=dis+edgeWt; // UPDATE DISTANCE
                    pq.add(new int[]{dist[adjNode],adjNode}); // PUSH UPDATED PAIR
                }
            }
        }

        return dist; // RETURN DISTANCES
    }
}

-----------Adjacency List + TreeSet + Distance Array + Edge Relaxation-----------------
import java.util.*;

class Solution {
    public int[] dijkstra(int V,ArrayList<ArrayList<Integer>> edges,int S) {

        ArrayList<ArrayList<int[]>> adj=new ArrayList<>(); // CREATE GRAPH
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(ArrayList<Integer> e:edges) {
            int u=e.get(0),v=e.get(1),wt=e.get(2);
            adj.get(u).add(new int[]{v,wt}); // ADD EDGE
            adj.get(v).add(new int[]{u,wt}); // UNDIRECTED EDGE
        }

        TreeSet<int[]> set=new TreeSet<>((a,b)-> {
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]); // SORT BY DIST, THEN NODE
        });

        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9); // INITIALIZE INFINITY

        dist[S]=0; // SOURCE DISTANCE
        set.add(new int[]{0,S}); // ADD SOURCE TO SET

        while(!set.isEmpty()) {
            int[] curr=set.pollFirst(); // POLL MINIMUM PAIR
            int dis=curr[0],node=curr[1];

            for(int[] it:adj.get(node)) { // TRAVERSE NEIGHBOURS
                int adjNode=it[0],edgeWt=it[1];

                if(dis+edgeWt<dist[adjNode]) { // EDGE RELAXATION
                    set.remove(new int[]{dist[adjNode],adjNode}); // REMOVE OLD PAIR
                    dist[adjNode]=dis+edgeWt; // UPDATE DISTANCE
                    set.add(new int[]{dist[adjNode],adjNode}); // INSERT NEW PAIR
                }
            }
        }

        return dist; // RETURN SHORTEST DISTANCES
    }
}
