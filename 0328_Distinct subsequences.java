-----------------------RECUR---------------------------------------
class Solution {
    private static final int prime=(int)(1e9+7);

    private int countUtil(String s,String t,int i,int j) {

        // Base case: Target completely matched → 1 valid way
        if(j<0)
            return 1;

        // Base case: Source exhausted before matching target → 0 ways
        if(i<0)
            return 0;

        // Match → Take current character OR Skip current character
        if(s.charAt(i)==t.charAt(j)) {
            int take=countUtil(s,t,i-1,j-1);
            int skip=countUtil(s,t,i-1,j);

            return (take+skip)%prime;
        }

        // No match → Only choice is to skip current source character
        return countUtil(s,t,i-1,j);
    }

    public int distinctSubsequences(String s,String t) {

        // Start from the last indexes of both strings
        int n=s.length();
        int m=t.length();

        return countUtil(s,t,n-1,m-1);
    }
}
----------------MEMO--------------------------

import java.util.*;

class Solution {
    private static final int prime=(int)(1e9+7);

    private int countUtil(String s,String t,int i,int j,int[][] dp) {

        if(j<0)
            return 1;

        if(i<0)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        if(s.charAt(i)==t.charAt(j)) {
            int take=countUtil(s,t,i-1,j-1,dp);
            int skip=countUtil(s,t,i-1,j,dp);

            return dp[i][j]=(take+skip)%prime;
        }

        return dp[i][j]=countUtil(s,t,i-1,j,dp);
    }

    public int distinctSubsequences(String s,String t) {
        int n=s.length();
        int m=t.length();

        int[][] dp=new int[n][m];

        for(int[] row:dp)
            Arrays.fill(row,-1);

        return countUtil(s,t,n-1,m-1,dp);
    }
}
---------------TABU----------------------------

class Solution {
    private static final int prime=(int)(1e9+7);

    public int distinctSubsequences(String s,String t) {
        int n=s.length();
        int m=t.length();

        int[][] dp=new int[n+1][m+1];

        // Empty target → 1 way
        for(int i=0;i<=n;i++)
            dp[i][0]=1;

        // Empty source + non-empty target → 0 ways
        for(int j=1;j<=m;j++)
            dp[0][j]=0;

        // Fill DP table
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {

                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%prime;
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][m];
    }
}

-----------------SPACE-------------------------------------

class Solution {
    private static final int prime=(int)(1e9+7);

    public int distinctSubsequences(String s,String t) {
        int n=s.length();
        int m=t.length();

        int[] prev=new int[m+1];

        // Empty target → 1 way
        prev[0]=1;

        for(int i=1;i<=n;i++) {
            for(int j=m;j>=1;j--) {
                if(s.charAt(i-1)==t.charAt(j-1))
                    prev[j]=(prev[j-1]+prev[j])%prime;
            }
        }

        return prev[m];
    }
}

