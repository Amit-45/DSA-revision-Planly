import java.util.*;

class Solution {
    private int[] delRow={-1,0,1,0}; // UP → RIGHT → DOWN → LEFT
    private int[] delCol={0,1,0,-1};

    private boolean isValid(int i,int j,int n,int m) {
        return i>=0 && i<n && j>=0 && j<m;
    }

    private void dfs(int row,int col,boolean[][] vis,char[][] mat,int n,int m) {
        Stack<int[]> stack=new Stack<>();

        // MARK START + PUSH
        vis[row][col]=true;
        stack.push(new int[]{row,col});

        // STACK NOT EMPTY → POP → CHECK 4 NEIGHBOURS
        while(!stack.isEmpty()) {
            int[] cell=stack.pop();
            int currRow=cell[0];
            int currCol=cell[1];

            for(int i=0;i<4;i++) {
                int nRow=currRow+delRow[i];
                int nCol=currCol+delCol[i];

                // VALID + 'O' + NOT VISITED → MARK + PUSH
                if(isValid(nRow,nCol,n,m) &&
                   mat[nRow][nCol]=='O' &&
                   !vis[nRow][nCol]) {
                    vis[nRow][nCol]=true;
                    stack.push(new int[]{nRow,nCol});
                }
            }
        }
    }

    public char[][] fill(char[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] vis=new boolean[n][m];

        // FIND BOUNDARY O → DFS CALL
        for(int j=0;j<m;j++) {
            if(mat[0][j]=='O' && !vis[0][j])
                dfs(0,j,vis,mat,n,m);

            if(mat[n-1][j]=='O' && !vis[n-1][j])
                dfs(n-1,j,vis,mat,n,m);
        }

        for(int i=0;i<n;i++) {
            if(mat[i][0]=='O' && !vis[i][0])
                dfs(i,0,vis,mat,n,m);

            if(mat[i][m-1]=='O' && !vis[i][m-1])
                dfs(i,m-1,vis,mat,n,m);
        }

        // TRAVERSE MATRIX → UNVISITED O: CHANGE TO X
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j]=='O' && !vis[i][j])
                    mat[i][j]='X';
            }
        }

        // RETURN MATRIX
        return mat;
    }
}
