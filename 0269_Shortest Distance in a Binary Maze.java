import java.util.*;

class Solution {
    private int[] delRow={-1,0,1,0};
    private int[] delCol={0,1,0,-1};

    private boolean isValid(int row,int col,int n,int m) {
        return row>=0 && row<n && col>=0 && col<m;
    }

    public int shortestPath(int[][] grid,int[] source,int[] destination) {

        if(source[0]==destination[0] && source[1]==destination[1]) return 0; // CHECK SOURCE == DESTINATION

        int n=grid.length,m=grid[0].length;

        Queue<int[]> q=new LinkedList<>(); // CREATE QUEUE

        int[][] dist=new int[n][m]; // DISTANCE MATRIX
        for(int[] row:dist) Arrays.fill(row,Integer.MAX_VALUE); // DIST = INFINITY

        dist[source[0]][source[1]]=0; // SOURCE = 0
        q.add(new int[]{0,source[0],source[1]}); // ADD SOURCE

        while(!q.isEmpty()) {
            int[] curr=q.poll(); // POLL CELL

            int dis=curr[0],row=curr[1],col=curr[2];

            for(int i=0;i<4;i++) { // TRAVERSE 4 DIRECTIONS

                int newRow=row+delRow[i];
                int newCol=col+delCol[i];

                if(isValid(newRow,newCol,n,m) && grid[newRow][newCol]==1) { // VALID + GRID == 1

                    int newDist=dis+1; // NEW DIST = DIS + 1

                    if(newDist<dist[newRow][newCol]) { // RELAX

                        dist[newRow][newCol]=newDist; // UPDATE DIST

                        if(newRow==destination[0] && newCol==destination[1])
                            return newDist; // CHECK DESTINATION

                        q.add(new int[]{newDist,newRow,newCol}); // ADD NEW CELL TO QUEUE
                    }
                }
            }
        }

        return -1; // QUEUE EMPTY = NO PATH
    }
}
