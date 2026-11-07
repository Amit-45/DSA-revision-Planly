------------------RECUR--------------------------------
f(i,j) {
    if(i>=0 && j>=0 && matrix[i][j]==1) return 0;
    if(i==0 && j==0) return 1;
    if(i<0 || j<0) return 0;

    up = f(i-1,j);
    left = f(i,j-1);

    return up+left;
}
------------MEMO----------------------------------------------
import java.util.*;
class Solution {
    private int func(int i,int j,int[][] matrix,int[][] dp) {
        if(i<0 || j<0) return 0;
        if(matrix[i][j]==1) return 0;
        if(i==0 && j==0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        int up=func(i-1,j,matrix,dp);
        int left=func(i,j-1,matrix,dp);

        return dp[i][j]=up+left;
    }

    public int uniquePathsWithObstacles(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m][n];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return func(m-1,n-1,matrix,dp);
    }
}
--------------------------TABU-----------------------------------------
class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==1) {
                    dp[i][j]=0;
                    continue;
                }

                if(i==0 && j==0) {
                    dp[i][j]=1;
                    continue;
                }

                int up=0;
                int left=0;

                if(i>0) up=dp[i-1][j];
                if(j>0) left=dp[i][j-1];

                dp[i][j]=up+left;
            }
        }

        return dp[m-1][n-1];
    }
}
------------SPACE OPTIMIZATION----------------------------
class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[] prev=new int[n];
        int[] curr=new int[n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==1) {
                    curr[j]=0;
                    continue;
                }

                if(i==0 && j==0) {
                    curr[j]=1;
                    continue;
                }

                int up=0;
                int left=0;

                if(i>0) up=prev[j];
                if(j>0) left=curr[j-1];

                curr[j]=up+left;
            }

            prev=curr.clone();
        }

        return prev[n-1];
    }
}
