import java.util.*;

class Solution {
    List<String> result=new ArrayList<>();

    private void backtrack(int[][] grid,int i,int j,String path,int n) {
        // STOP: Reached destination? Save the complete path.
        if(i==n-1&&j==n-1) {
            result.add(path);
            return;
        }

        // CHECK: Is this cell blocked or already visited?
        if(grid[i][j]==0)return;

        // MARK: Prevent revisiting this cell in the current path.
        grid[i][j]=0;

        // TRY: Explore each direction that stays inside the grid.
        if(i>0)backtrack(grid,i-1,j,path+'U',n);
        if(j>0)backtrack(grid,i,j-1,path+'L',n);
        if(i<n-1)backtrack(grid,i+1,j,path+'D',n);
        if(j<n-1)backtrack(grid,i,j+1,path+'R',n);

        // BACKTRACK: Restore the cell for other possible paths.
        grid[i][j]=1;
    }

    public List<String> findPath(int[][] grid) {
        int n=grid.length;
        result.clear();

        // CHECK: If start or destination is blocked, no path exists.
        if(grid[0][0]==0||grid[n-1][n-1]==0)return result;

        // START: Search from the top-left cell with an empty path.
        backtrack(grid,0,0,"",n);

        // SORT: Return paths in alphabetical order.
        Collections.sort(result);
        return result;
    }
}
