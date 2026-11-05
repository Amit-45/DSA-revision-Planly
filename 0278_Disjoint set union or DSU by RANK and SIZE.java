import java.util.*;

class DisjointSet {
    private int[] rank;
    private int[] size;
    private int[] parent;

    // INITIALIZE → RANK = 0, SIZE = 1, PARENT = SELF
    public DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    // FIND ULTIMATE PARENT → PATH COMPRESSION
    public int findUPar(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = findUPar(parent[node]);
    }

    // CHECK SAME COMPONENT → COMPARE ULTIMATE PARENTS
    public boolean find(int u, int v) {
        return findUPar(u) == findUPar(v);
    }

    // UNION BY RANK → FIND PARENTS
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        // SMALLER RANK → ATTACH UNDER LARGER RANK
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        // EQUAL RANK → ATTACH + INCREMENT RANK
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // UNION BY SIZE → FIND PARENTS
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        // SMALLER SIZE → ATTACH UNDER LARGER SIZE
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
