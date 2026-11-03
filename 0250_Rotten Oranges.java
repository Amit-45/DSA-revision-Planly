import java.util.*;

class Solution {
    private int[] delRow={-1,0,1,0}; // UP → RIGHT → DOWN → LEFT
    private int[] delCol={0,1,0,-1};

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int total=0;
        int count=0;
        int time=0;

        // COUNT TOTAL + ADD ALL ROTTEN ORANGES
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]!=0)total++;
                if(grid[i][j]==2) {
                    q.add(new int[]{i,j});
                }
            }
        }

        // BFS LEVEL ORDER → EACH LEVEL = ONE MINUTE
        while(!q.isEmpty()) {
            int k=q.size();
            count+=k;

            // PROCESS CURRENT LEVEL
            while(k-->0) {
                int[] cell=q.poll();
                int row=cell[0];
                int col=cell[1];

                // CHECK 4 NEIGHBOURS
                for(int i=0;i<4;i++) {
                    int nrow=row+delRow[i];
                    int ncol=col+delCol[i];

                    // VALID + FRESH → ROT + ENQUEUE
                    if(nrow>=0 && nrow<n &&
                    ncol>=0 && ncol<m &&
                    grid[nrow][ncol]==1) {
                        grid[nrow][ncol]=2;
                        q.add(new int[]{nrow,ncol});
                    }
                }
            }

            // NEW ORANGES ROTTEN → INCREMENT TIME
            if(!q.isEmpty())time++;
        }

        // ALL ORANGES ROTTEN? RETURN TIME : -1
        return total==count?time:-1;
    }
}
