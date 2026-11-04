import java.util.*;

class Solution {
    private int[] delRow={-1,0,1,0};
    private int[] delCol={0,-1,0,1};

    private boolean isValid(int i,int j,int n,int m) {
        return i>=0 && i<n && j>=0 && j<m;
    }

    private void dfs(int row,int col,int[][] grid,boolean[][] vis,
                     StringBuilder path,int baseRow,int baseCol) {

        // MARK VISITED
        vis[row][col]=true;

        // CALCULATE RELATIVE COORDINATES → STORE IN PATH
        path.append(row-baseRow).append(',')
            .append(col-baseCol).append(';');

        // CHECK 4 NEIGHBOURS
        for(int i=0;i<4;i++) {
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];

            // VALID + LAND (1) + NOT VISITED → DFS CALL
            if(isValid(nRow,nCol,grid.length,grid[0].length) &&
               grid[nRow][nCol]==1 && !vis[nRow][nCol]) {
                dfs(nRow,nCol,grid,vis,path,baseRow,baseCol);
            }
        }
        // BACKTRACK
    }

    public int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        // CREATE VIS + SET
        boolean[][] vis=new boolean[n][m];
        Set<String> shapes=new HashSet<>();

        // TRAVERSE GRID → FIND UNVISITED LAND (1)
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1 && !vis[i][j]) {

                    // CREATE PATH
                    StringBuilder path=new StringBuilder();

                    // DFS CALL
                    dfs(i,j,grid,vis,path,i,j);

                    // ADD SHAPE TO SET
                    shapes.add(path.toString());
                }
            }
        }

        // RETURN SET SIZE
        return shapes.size();
    }
}
