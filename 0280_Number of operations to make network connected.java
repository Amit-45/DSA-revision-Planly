import java.util.*;
class DisjointSet {
    int[] rank, parent, size;
    // INITIALIZE → PARENT = SELF, SIZE = 1
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    // FIND ULTIMATE PARENT → PATH COMPRESSION
    int findUPar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }
    // UNION BY RANK
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}

class Solution {
    public int solve(int n, int[][] Edge) {

        // CHECK EDGES → LESS THAN N-1 MEANS IMPOSSIBLE
        int m = Edge.length;
        if (m < n - 1) return -1;

        // INITIALIZE DSU → EVERY NODE IS ITS OWN PARENT
        DisjointSet ds = new DisjointSet(n);

        // TRAVERSE EDGES → FIND ULTIMATE PARENTS
        for (int i = 0; i < m; i++) {
            int u = Edge[i][0];
            int v = Edge[i][1];

            int ulp_u = ds.findUPar(u);
            int ulp_v = ds.findUPar(v);

            // SAME PARENT → ALREADY CONNECTED → EXTRA EDGE
            if (ulp_u == ulp_v) continue;

            // DIFFERENT PARENTS → MERGE BOTH COMPONENTS
            ds.unionByRank(u, v);
        }

        // COUNT COMPONENTS → COUNT ROOT NODES
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) count++;
        }

        // FINAL ANSWER → COMPONENTS - 1
        return count - 1;
    }
}
