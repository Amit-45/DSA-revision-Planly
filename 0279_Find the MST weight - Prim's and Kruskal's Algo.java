--------------PRIMS-----------------------------
import java.util.*;
class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        // MIN HEAP → {edgeWt, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        // VISITED ARRAY
        boolean[] visited = new boolean[V];

        // START NODE → {0, 0}
        pq.add(new int[]{0, 0});
        int sum = 0;

        // PROCESS UNTIL HEAP EMPTY
        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int wt = p[0];
            int node = p[1];

            // ALREADY VISITED → SKIP
            if (visited[node]) continue;

            // VISIT NODE → ADD EDGE WEIGHT
            visited[node] = true;
            sum += wt;

            // TRAVERSE NEIGHBOURS
            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);

                // NOT VISITED → PUSH INTO HEAP
                if (!visited[adjNode]) {
                    pq.add(new int[]{edgeWt, adjNode});
                }
            }
        }

        // RETURN MST SUM
        return sum;
    }
}
--------------------------KRUSKALS----------------------------------------------
import java.util.*;

class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        // COLLECT EDGES → {wt, u, v}
        List<int[]> edges = new ArrayList<>();

        for (int u = 0; u < V; u++) {
            for (List<Integer> it : adj.get(u)) {
                int v = it.get(0);
                int wt = it.get(1);

                edges.add(new int[]{wt, u, v});
            }
        }

        // INITIALIZE DSU
        DisjointSet ds = new DisjointSet(V);

        // SORT EDGES → INCREASING WEIGHT
        edges.sort(Comparator.comparingInt(a -> a[0]));

        int sum = 0;

        // TRAVERSE SORTED EDGES
        for (int[] it : edges) {
            int wt = it[0];
            int u = it[1];
            int v = it[2];

            // SAME PARENT → SKIP (CYCLE)
            if (ds.findUPar(u) == ds.findUPar(v))
                continue;

            // DIFFERENT PARENT → ACCEPT EDGE
            sum += wt;

            // MERGE GROUPS
            ds.unionBySize(u, v);
        }

        // RETURN MST SUM
        return sum;
    }
}
