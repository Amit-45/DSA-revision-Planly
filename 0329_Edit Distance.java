------------------------------RECUR----------------------------
class Solution {
    private int func(String start,String target,int i,int j) {
        // Start exhausted → Insert remaining target characters
        if(i<0)
            return j+1;

        // Target exhausted → Delete remaining start characters
        if(j<0)
            return i+1;

        // Match → No operation, move both indexes
        if(start.charAt(i)==target.charAt(j))
            return func(start,target,i-1,j-1);

        // No match → Try Insert, Delete and Replace
        int insert=1+func(start,target,i,j-1);
        int delete=1+func(start,target,i-1,j);
        int replace=1+func(start,target,i-1,j-1);

        // Return minimum of all three choices
        return Math.min(insert,Math.min(delete,replace));
    }

    public int editDistance(String start,String target) {
        int n=start.length();
        int m=target.length();

        return func(start,target,n-1,m-1);
    }
}
--------------------MEMO-----------------
import java.util.*;

class Solution {
    private int func(String start,String target,int i,int j,int[][] dp) {
        // Start exhausted → Insert remaining target characters
        if(i<0)
            return j+1;

        // Target exhausted → Delete remaining start characters
        if(j<0)
            return i+1;

        // Already calculated → Return stored answer
        if(dp[i][j]!=-1)
            return dp[i][j];

        // Match → No operation, move both indexes
        if(start.charAt(i)==target.charAt(j))
            return dp[i][j]=func(start,target,i-1,j-1,dp);

        // No match → Try Insert, Delete and Replace
        int insert=1+func(start,target,i,j-1,dp);
        int delete=1+func(start,target,i-1,j,dp);
        int replace=1+func(start,target,i-1,j-1,dp);

        // Store and return minimum of all three choices
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }

    public int editDistance(String start,String target) {
        int n=start.length();
        int m=target.length();

        // Create dp[n][m] and initialize with -1
        int[][] dp=new int[n][m];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        return func(start,target,n-1,m-1,dp);
    }
}
----------------------TABU-------------------------------------------------
class Solution {
    public int editDistance(String start,String target) {
        int n=start.length();
        int m=target.length();

        // Create dp[n+1][m+1]
        int[][] dp=new int[n+1][m+1];

        // Base cases: Empty target → Delete all start characters
        for(int i=0;i<=n;i++)
            dp[i][0]=i;

        // Empty start → Insert all target characters
        for(int j=0;j<=m;j++)
            dp[0][j]=j;

        // Traverse the DP table
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {

                // Match → No operation, take diagonal value
                if(start.charAt(i-1)==target.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];

                // No match → Try Insert, Delete and Replace
                else
                    dp[i][j]=1+Math.min(dp[i][j-1],
                              Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }

        return dp[n][m];
    }
}
-------------------SPACE OPTI--------------------------
class Solution {
    public int editDistance(String start,String target) {
        int n=start.length();
        int m=target.length();

        int[] prev=new int[m+1];
        int[] cur=new int[m+1];

        // Initialize previous row
        for(int j=0;j<=m;j++)
            prev[j]=j;

        for(int i=1;i<=n;i++) {
            // Base case for current row
            cur[0]=i;

            for(int j=1;j<=m;j++) {
                // Match → Take diagonal from previous row
                if(start.charAt(i-1)==target.charAt(j-1))
                    cur[j]=prev[j-1];

                // No match → Insert, Delete or Replace
                else
                    cur[j]=1+Math.min(prev[j-1],
                              Math.min(prev[j],cur[j-1]));
            }

            // Current row becomes previous row
            prev=cur.clone();
        }

        return prev[m];
    }
}
