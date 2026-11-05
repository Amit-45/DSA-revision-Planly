import java.util.*;
class Solution {
    public int[] bellman_ford(int V,ArrayList<ArrayList<Integer>> edges,int S) {

        // INIT DIST = INFINITY
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9);

        // SOURCE = 0
        dist[S]=0;

        // V-1 ITERATIONS → TRAVERSE ALL EDGES
        for(int i=0;i<V-1;i++) {

            for(ArrayList<Integer> it:edges) {
                int u=it.get(0);
                int v=it.get(1);
                int wt=it.get(2);

                // RELAX → UPDATE DISTANCE
                if(dist[u]!=(int)1e9 && dist[u]+wt<dist[v]) {
                    dist[v]=dist[u]+wt;
                }
            }
        }

        // EXTRA ITERATION → NEGATIVE CYCLE CHECK
        for(ArrayList<Integer> it:edges) {
            int u=it.get(0);
            int v=it.get(1);
            int wt=it.get(2);

            if(dist[u]!=(int)1e9 && dist[u]+wt<dist[v]) {
                return new int[]{-1};
            }
        }

        // RETURN DISTANCE ARRAY
        return dist;
    }
}
