----------RECUR-----------------------------------------------
f(i,j) {
    if(i==n-1) return triangle[i][j];

    down = triangle[i][j] + f(i+1,j);

    diagonal = triangle[i][j] + f(i+1,j+1);

    return Math.min(down,diagonal);
}
----------MEMO-----------------------------------------------
import java.util.*;

class Solution {
    private int func(int i,int j,int[][] triangle,int n,int[][] dp) {
        if(dp[i][j]!=-1) return dp[i][j];

        if(i==n-1) return dp[i][j]=triangle[i][j];

        int down=triangle[i][j]+func(i+1,j,triangle,n,dp);
        int diagonal=triangle[i][j]+func(i+1,j+1,triangle,n,dp);

        return dp[i][j]=Math.min(down,diagonal);
    }

    public int minTriangleSum(int[][] triangle) {
        int n=triangle.length;
        int[][] dp=new int[n][n];

        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        return func(0,0,triangle,n,dp);
    }
}
--------TABU-----------------------------------------------------

class Solution {
    public int minTriangleSum(int[][] triangle) {
        int n=triangle.length;
        int[][] dp=new int[n][n];

        for(int j=0;j<n;j++) {
            dp[n-1][j]=triangle[n-1][j];
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=i;j>=0;j--) {
                int down=triangle[i][j]+dp[i+1][j];
                int diagonal=triangle[i][j]+dp[i+1][j+1];

                dp[i][j]=Math.min(down,diagonal);
            }
        }

        return dp[0][0];
    }
}
----------------SPACE OPTIMIZATION--------------------------------------------

class Solution {
    public int minTriangleSum(int[][] triangle) {
        int n=triangle.length;

        int[] front=new int[n];
        int[] cur=new int[n];

        for(int j=0;j<n;j++) {
            front[j]=triangle[n-1][j];
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=i;j>=0;j--) {
                int down=triangle[i][j]+front[j];
                int diagonal=triangle[i][j]+front[j+1];

                cur[j]=Math.min(down,diagonal);
            }

            front=cur.clone();
        }

        return front[0];
    }
}

