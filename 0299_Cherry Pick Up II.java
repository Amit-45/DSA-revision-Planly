----------RECUR-----------------------------------------------
f(i,j1,j2) {

    if(j1<0 || j1>=m || j2<0 || j2>=m)
        return -1e9;

    if(i==n-1) {
        if(j1==j2) return matrix[i][j1];
        else return matrix[i][j1]+matrix[i][j2];
    }

    current=matrix[i][j1];
    if(j1!=j2) {
        current+=matrix[i][j2];
    }

    maxi=Integer.MIN_VALUE;
    for(di=-1;di<=1;di++) {
        for(dj=-1;dj<=1;dj++) {

            ans=current+f(i+1,j1+di,j2+dj);

            maxi=Math.max(maxi,ans);
        }
    }
    return maxi;
}
------------MEMO--------------------
3-D DP 
---------------------------------------
import java.util.*;

class Solution {
    private int func(int i,int j1,int j2,int n,int m,int[][] matrix,int[][][] dp) {
        if(j1<0||j1>=m||j2<0||j2>=m) return -1000000000;

        if(i==n-1) {
            if(j1==j2) return matrix[i][j1];
            return matrix[i][j1]+matrix[i][j2];
        }

        if(dp[i][j1][j2]!=-1) {
            return dp[i][j1][j2];
        }

        int current=matrix[i][j1];

        if(j1!=j2) {
            current+=matrix[i][j2];
        }

        int maxi=Integer.MIN_VALUE;

        for(int di=-1;di<=1;di++) {
            for(int dj=-1;dj<=1;dj++) {
                int ans=current+func(i+1,j1+di,j2+dj,n,m,matrix,dp);
                maxi=Math.max(maxi,ans);
            }
        }

        return dp[i][j1][j2]=maxi;
    }

    public int cherryPickup(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[][][] dp=new int[n][m][m];

        for(int[][] row1:dp) {
            for(int[] row2:row1) {
                Arrays.fill(row2,-1);
            }
        }

        return func(0,0,m-1,n,m,matrix,dp);
    }
}
-----------------TABU------------------------------------------

class Solution {
    public int cherryPickup(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[][][] dp=new int[n][m][m];

        for(int j1=0;j1<m;j1++) {
            for(int j2=0;j2<m;j2++) {
                if(j1==j2) {
                    dp[n-1][j1][j2]=matrix[n-1][j1];
                } else {
                    dp[n-1][j1][j2]=matrix[n-1][j1]+matrix[n-1][j2];
                }
            }
        }

        for(int i=n-2;i>=0;i--) {
            for(int j1=0;j1<m;j1++) {
                for(int j2=0;j2<m;j2++) {
                    int current=matrix[i][j1];

                    if(j1!=j2) {
                        current+=matrix[i][j2];
                    }

                    int maxi=Integer.MIN_VALUE;

                    for(int di=-1;di<=1;di++) {
                        for(int dj=-1;dj<=1;dj++) {
                            int ans=-1000000000;

                            int nj1=j1+di;
                            int nj2=j2+dj;

                            if(nj1>=0&&nj1<m&&nj2>=0&&nj2<m) {
                                ans=current+dp[i+1][nj1][nj2];
                            }

                            maxi=Math.max(maxi,ans);
                        }
                    }

                    dp[i][j1][j2]=maxi;
                }
            }
        }

        return dp[0][0][m-1];
    }
}
-------------SPACE OPTI----------------------------

class Solution {
    public int cherryPickup(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[][] front=new int[m][m];
        int[][] cur=new int[m][m];

        for(int j1=0;j1<m;j1++) {
            for(int j2=0;j2<m;j2++) {
                if(j1==j2) {
                    front[j1][j2]=matrix[n-1][j1];
                } else {
                    front[j1][j2]=matrix[n-1][j1]+matrix[n-1][j2];
                }
            }
        }

        for(int i=n-2;i>=0;i--) {
            for(int j1=0;j1<m;j1++) {
                for(int j2=0;j2<m;j2++) {
                    int current=matrix[i][j1];

                    if(j1!=j2) {
                        current+=matrix[i][j2];
                    }

                    int maxi=Integer.MIN_VALUE;

                    for(int di=-1;di<=1;di++) {
                        for(int dj=-1;dj<=1;dj++) {
                            int ans=-1000000000;

                            int nj1=j1+di;
                            int nj2=j2+dj;

                            if(nj1>=0&&nj1<m&&nj2>=0&&nj2<m) {
                                ans=current+front[nj1][nj2];
                            }

                            maxi=Math.max(maxi,ans);
                        }
                    }

                    cur[j1][j2]=maxi;
                }
            }

            for(int j1=0;j1<m;j1++) {
                front[j1]=cur[j1].clone();
            }
        }

        return front[0][m-1];
    }
}
