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
import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[][] dp=new int[n][m];

        for(int j=0;j<m;j++) {
            dp[0][j]=matrix[0][j];
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                int up=matrix[i][j]+dp[i-1][j];

                int leftDiagonal=(int)1e9;
                if(j-1>=0) {
                    leftDiagonal=matrix[i][j]+dp[i-1][j-1];
                }

                int rightDiagonal=(int)1e9;
                if(j+1<m) {
                    rightDiagonal=matrix[i][j]+dp[i-1][j+1];
                }

                dp[i][j]=Math.min(up,Math.min(leftDiagonal,rightDiagonal));
            }
        }

        int mini=Integer.MAX_VALUE;

        for(int j=0;j<m;j++) {
            mini=Math.min(mini,dp[n-1][j]);
        }

        return mini;
    }
}
---------------SPACE OPTIMIZATION ----------------------------------------
import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[] prev=new int[m];
        int[] cur=new int[m];

        for(int j=0;j<m;j++) {
            prev[j]=matrix[0][j];
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                int up=matrix[i][j]+prev[j];

                int leftDiagonal=(int)1e9;
                if(j-1>=0) {
                    leftDiagonal=matrix[i][j]+prev[j-1];
                }

                int rightDiagonal=(int)1e9;
                if(j+1<m) {
                    rightDiagonal=matrix[i][j]+prev[j+1];
                }

                cur[j]=Math.min(up,Math.min(leftDiagonal,rightDiagonal));
            }

            System.arraycopy(cur,0,prev,0,m);
        }

        int mini=Integer.MAX_VALUE;

        for(int j=0;j<m;j++) {
            mini=Math.min(mini,prev[j]);
        }

        return mini;
    }
}
