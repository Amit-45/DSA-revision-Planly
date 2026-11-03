import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m]; // CREATE VISITED[n][m]
        int count=0;

        // TRAVERSE ALL CELLS
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // UNVISITED LAND → COUNT++ → BFS CALL
                if(grid[i][j]=='1' && !vis[i][j]) {                
                    count++;
                    bfs(i,j,vis,grid); // ENTIRE ISLAND VISITED
                }
            }
        }
        return count;
    }

    //-----------------------------BFS HELPER--------------------------------
    // MARK + ENQUEUE → REMOVE → CHECK 8 NEIGHBOURS
    private void bfs(int i,int j,boolean[][] vis,char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{i,j}); // ENQUEUE START
        vis[i][j]=true; // MARK

        while(!q.isEmpty()) {
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];

            for(int delRow=-1;delRow<=1;delRow++) {
                for(int delCol=-1;delCol<=1;delCol++) {
                    int newRow=row+delRow;
                    int newCol=col+delCol;

                    // VALID + LAND + UNVISITED → MARK + ENQUEUE
                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<m
                    && grid[newRow][newCol]=='1' && !vis[newRow][newCol]) {
                        vis[newRow][newCol]=true;
                        q.add(new int[]{newRow,newCol});
                    }
                }
            }
        }
    }
}
