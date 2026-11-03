import java.util.*;

class Solution {
    private int[] delRow={-1,0,1,0}; // UP → RIGHT → DOWN → LEFT
    private int[] delCol={0,1,0,-1};

    private void bfs(int[][] grid,Queue<int[]> q,boolean[][] vis) {
        int n=grid.length;
        int m=grid[0].length;

        // REMOVE → GET ROW/COL → CHECK 4 NEIGHBOURS
        while(!q.isEmpty()) {
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];

            for(int i=0;i<4;i++) {
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];

                // VALID ROW + VALID COL + LAND + NOT VISITED → MARK + ENQUEUE
                if(nrow>=0 && nrow<n &&
                ncol>=0 && ncol<m &&
                grid[nrow][ncol]==1 && !vis[nrow][ncol]) {
                    vis[nrow][ncol]=true;
                    q.add(new int[]{nrow,ncol});
                }
            }
        }
    }

    public int numberOfEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();

        // FIND BOUNDARY LAND → MARK + ENQUEUE
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if((i==0 || i==n-1 || j==0 || j==m-1) && grid[i][j]==1) {
                    vis[i][j]=true;
                    q.add(new int[]{i,j});
                }
            }
        }

        // BFS FROM ALL BOUNDARY LAND
        bfs(grid,q,vis);

        int count=0;
        // COUNT UNVISITED LAND (1)
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1 && !vis[i][j])count++;
            }
        }

        return count;
    }
}
//Boundary condition: TOP (i==0) → BOTTOM (i==n-1) → LEFT (j==0) → RIGHT (j==m-1)
//Neighbour condition:  VALID ROW + VALID COL + LAND (grid[][]==1) + NOT VISITED → MARK + ENQUEUE
