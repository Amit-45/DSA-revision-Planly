----------------------RECUR-----------------------------------------------
f(i,j) {
    if(j<0 || j>=m) {
        return 1000000000;
    }
  
    if(i==0) {
        return matrix[0][j];
    }

    up = matrix[i][j] + f(i-1,j);
    leftDiagonal = matrix[i][j] + f(i-1,j-1);
    rightDiagonal = matrix[i][j] + f(i-1,j+1);
  
    return Math.min(up,Math.min(leftDiagonal,rightDiagonal));
}
------MEMO---------------------------------------------------------------
import java.util.*;

class Solution {
    private int func(int i,int j,int m,int[][] matrix,int[][] dp) {
        if(j<0 || j>=m) {
            return (int)1e9;
        }

        if(i==0) {
            return matrix[0][j];
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int up=matrix[i][j]+func(i-1,j,m,matrix,dp);
        int leftDiagonal=matrix[i][j]+func(i-1,j-1,m,matrix,dp);
        int rightDiagonal=matrix[i][j]+func(i-1,j+1,m,matrix,dp);

        return dp[i][j]=Math.min(up,Math.min(leftDiagonal,rightDiagonal));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[][] dp=new int[n][m];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        int mini=Integer.MAX_VALUE;

        for(int j=0;j<m;j++) {
            mini=Math.min(mini,func(n-1,j,m,matrix,dp));
        }

        return mini;
    }
}
--------------------TABU---------------------------------------------------
