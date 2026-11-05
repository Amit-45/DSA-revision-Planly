-------------------------Dijkstra + Normal queue-------------------------------------------------------
import java.util.*;

class Solution {

    // CHEAPEST ROUTE + K STOPS → TRACK COST + STOPS
    public int CheapestFlight(int n,int[][] flights,int src,int dst,int k) {

        if(src==dst) return 0;

        // BUILD GRAPH → ADD DIRECTED FLIGHTS
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] flight:flights) {
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        // DIST = INFINITY
        int[] minDist=new int[n];
        Arrays.fill(minDist,Integer.MAX_VALUE);

        // QUEUE → {STOPS,NODE,DISTANCE}
        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{0,src,0}); // ADD SOURCE (0 STOPS, SRC, 0 COST)
        minDist[src]=0;

        while(!q.isEmpty()) {
            int[] curr=q.poll(); // POLL

            int stops=curr[0],node=curr[1],dist=curr[2];

            if(stops>k) continue; // CHECK STOPS

            // TRAVERSE FLIGHTS
            for(int[] it:adj.get(node)) {
                int adjNode=it[0],wt=it[1];

                int newCost=dist+wt; // NEW COST = DIST + WEIGHT

                // RELAX → CHECK COST + STOP LIMIT
                if(newCost<minDist[adjNode] && stops<=k) {

                    minDist[adjNode]=newCost; // UPDATE DIST

                    q.add(new int[]{stops+1,adjNode,newCost}); // ENQUEUE (STOPS+1)
                }
            }
        }

        // RETURN DESTINATION COST
        return minDist[dst]==Integer.MAX_VALUE?-1:minDist[dst];
    }
}
