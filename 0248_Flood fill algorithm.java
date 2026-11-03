import java.util.*;

class Solution {
    private int[] delRow={-1,0,1,0}; // UP->RIGHT->DOWN->LEFT 
    private int[] delCol={0,1,0,-1};

    private void dfs(int row,int col,int[][] ans,int[][] image,int iniColor,int newColor) {
        ans[row][col]=newColor; // CHANGE CURRENT COLOR

        for(int i=0;i<4;i++) { // CHECK 4 NEIGHBOURS
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            
            // VALID ROW(0 TO N-1) + VALID COL(0 TO M-1) → SAME ORIGINAL COLOR → NOT VISITED(pixel has not already been changed to newColor) → DFS CALL
            if(nrow>=0 && nrow<image.length &&       
            ncol>=0 && ncol<image[0].length &&    
            image[nrow][ncol]==iniColor &&        
            ans[nrow][ncol]!=newColor) {          
                dfs(nrow,ncol,ans,image,iniColor,newColor);                 //DFS CALL
            }
            }
        }
    }

    public int[][] floodFill(int[][] image,int sr,int sc,int newColor) {
        int iniColor=image[sr][sc]; // STORE ORIGINAL COLOR

        if(iniColor==newColor)return image; // SAME COLOR

        int[][] ans=new int[image.length][image[0].length];

        for(int i=0;i<image.length;i++) {
            ans[i]=image[i].clone(); // COPY IMAGE
        }

        dfs(sr,sc,ans,image,iniColor,newColor); // START DFS

        return ans;
    }
}
