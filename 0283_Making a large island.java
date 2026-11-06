import java.util.*;
class DisjointSet {
    int[] rank, parent, size;
    DisjointSet(int n) {
        rank=new int[n+1];
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
        }
    }
    int findUPar(int node) {
        if(node==parent[node]) return node;
        return parent[node]=findUPar(parent[node]);
    }

    void unionByRank(int u, int v) {
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;

        if(rank[ulp_u]<rank[ulp_v]) {
            parent[ulp_u]=ulp_v;
        }
        else if(rank[ulp_v]<rank[ulp_u]) {
            parent[ulp_v]=ulp_u;
        }
        else {
            parent[ulp_v]=ulp_u;
            rank[ulp_u]++;
        }
    }

    void unionBySize(int u, int v) {
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return;

        if(size[ulp_u]<size[ulp_v]) {
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else {
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }
}

class Solution {

    private int[] delRow={-1,0,1,0};
    private int[] delCol={0,1,0,-1};

    private boolean isValid(int i, int j, int n) {
        if(i<0 || i>=n) return false;
        if(j<0 || j>=n) return false;
        return true;
    }

    // 1. INITIALIZE DSU → Create DSU for n*n cells.
    // 2. ADD INITIAL ISLANDS → Traverse grid and union adjacent 1s.
    private void addInitialIslands(int[][] grid, DisjointSet ds, int n) {

        for(int row=0;row<n;row++) {
            for(int col=0;col<n;col++) {

                if(grid[row][col]==0) continue;

                for(int ind=0;ind<4;ind++) {
                    int newRow=row+delRow[ind];
                    int newCol=col+delCol[ind];

                    if(isValid(newRow,newCol,n) && grid[newRow][newCol]==1) {

                        int nodeNo=row*n+col;
                        int adjNodeNo=newRow*n+newCol;

                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }
    }

    public int largestIsland(int[][] grid) {

        int n=grid.length;

        // 1. INITIALIZE DSU
        DisjointSet ds=new DisjointSet(n*n);

        // 2. ADD INITIAL ISLANDS
        addInitialIslands(grid,ds,n);

        int ans=0;

        // 3. TRAVERSE GRID AGAIN → Find every 0.
        for(int row=0;row<n;row++) {
            for(int col=0;col<n;col++) {

                // Skip existing land.
                if(grid[row][col]==1) continue;

                // 4. ASSUME ZERO BECOMES ONE → Start size = 1.

                // 5. INITIALIZE HASHSET → Store unique neighbouring parents.
                Set<Integer> components=new HashSet<>();

                // 6. CHECK 4 DIRECTIONS → Up, right, down, left.
                for(int ind=0;ind<4;ind++) {
                    int newRow=row+delRow[ind];
                    int newCol=col+delCol[ind];

                    // 7. VALID LAND NEIGHBOUR → Find its ultimate parent.
                    if(isValid(newRow,newCol,n) && grid[newRow][newCol]==1) {

                        int nodeNumber=newRow*n+newCol;
                        int parent=ds.findUPar(nodeNumber);

                        // 8. NEW PARENT → Add only unique parents to HashSet.
                        components.add(parent);
                    }
                }

                // 9. CALCULATE SIZE → Add sizes of all unique neighbouring islands.
                int sizeTotal=1;

                for(int parent:components) {
                    sizeTotal+=ds.size[ds.findUPar(parent)];
                }

                // 10. UPDATE MAXIMUM → Store maximum possible island size.
                ans=Math.max(ans,sizeTotal);
            }
        }

        // 11. ALL ONES / EXISTING ISLANDS → Check largest existing component.
        for(int cellNo=0;cellNo<n*n;cellNo++) {
            ans=Math.max(ans,ds.size[ds.findUPar(cellNo)]);
        }

        // 12. RETURN ANSWER.
        return ans;
    }
}
