import java.util.*;

class DisjointSet {
    int[] rank, parent, size;

    // INITIALIZE DSU
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // FIND ULTIMATE PARENT
    int findUPar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    // UNION BY SIZE
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {

    // FOUR DIRECTIONS → UP, RIGHT, DOWN, LEFT
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};

    // CHECK GRID BOUNDARIES
    boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public List<Integer> numOfIslands(int n, int m, int[][] A) {

        // INITIALIZE DSU → N*M CELLS
        DisjointSet ds = new DisjointSet(n * m);

        // INITIALIZE VISITED → ALL CELLS ARE WATER
        int[][] vis = new int[n][m];

        // INITIALIZE COUNT + ANSWER
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        // TRAVERSE OPERATIONS
        for (int[] it : A) {
            int row = it[0];
            int col = it[1];

            // ALREADY LAND → SKIP
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            // NEW LAND → MARK VISITED + INCREMENT COUNT
            vis[row][col] = 1;
            cnt++;

            // CONVERT CELL TO DSU NODE
            int node = row * m + col;

            // CHECK FOUR DIRECTIONS
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                // VALID NEIGHBOUR + ALREADY LAND
                if (isValid(newRow, newCol, n, m) &&
                    vis[newRow][newCol] == 1) {

                    // CONVERT NEIGHBOUR TO DSU NODE
                    int adjNode = newRow * m + newCol;

                    // FIND ULTIMATE PARENTS
                    int ulp_u = ds.findUPar(node);
                    int ulp_v = ds.findUPar(adjNode);

                    // DIFFERENT PARENTS → UNION + DECREASE COUNT
                    if (ulp_u != ulp_v) {
                        ds.unionBySize(node, adjNode);
                        cnt--;
                    }
                }
            }

            // STORE CURRENT ISLAND COUNT
            ans.add(cnt);
        }

        // RETURN ANSWER
        return ans;
    }
}
