import java.util.*;

class Solution {
    private int[] delRow={-1,0,1,0}; // UP → RIGHT → DOWN → LEFT
    private int[] delCol={0,1,0,-1};

    private boolean isValid(int i,int j,int n,int m) {
        // VALID ROW + VALID COLUMN
        if(i<0 || i>=n)return false;
        if(j<0 || j>=m)return false;
        return true;
    }

    public int[][] nearest(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];
        Queue<int[]> q=new LinkedList<>();

        // FIND ALL 1s → MARK + ENQUEUE WITH DISTANCE 0
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    vis[i][j]=1;
                    q.add(new int[]{i,j,0});
                }
            }
        }

        // MULTI-SOURCE BFS
        while(!q.isEmpty()) {
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            int steps=cell[2];

            dist[row][col]=steps;

            // CHECK 4 NEIGHBOURS
            for(int i=0;i<4;i++) {
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];

                // VALID + NOT VISITED → MARK + ENQUEUE (STEPS+1)
                if(isValid(nrow,ncol,n,m) && vis[nrow][ncol]==0) {
                    vis[nrow][ncol]=1;
                    q.add(new int[]{nrow,ncol,steps+1});
                }
            }
        }

        return dist;
    }
}
