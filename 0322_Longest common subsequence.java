------------Recur----------------------
import java.util.*;
class Solution {
    // 1. TWO INDEXES - REPRESENT BOTH STRINGS
    private int func(String s1,String s2,int ind1,int ind2) {

        // 2. BASE CASE - ANY INDEX NEGATIVE
        if(ind1<0 || ind2<0) {
            return 0;
        }

        // 3. MATCH - TAKE BOTH + DIAGONAL + 1
        if(s1.charAt(ind1)==s2.charAt(ind2)) {
            return 1+func(s1,s2,ind1-1,ind2-1);
        }

        // 4. NO MATCH - TWO CHOICES + MAX
        return Math.max(
            func(s1,s2,ind1,ind2-1),
            func(s1,s2,ind1-1,ind2)
        );
    }

    public int lcs(String str1,String str2) {

        int n=str1.length();
        int m=str2.length();

        // 5. START FROM LAST INDEX
        return func(str1,str2,n-1,m-1);
    }
}
------------Memo-----------------------
import java.util.*;

class Solution {

    // 1. TWO INDEXES - REPRESENT BOTH STRINGS
    private int func(String s1,String s2,int ind1,int ind2,int[][] dp) {

        // 2. BASE CASE - ANY INDEX NEGATIVE
        if(ind1<0 || ind2<0) {
            return 0;
        }

        // 3. CHECK IF ALREADY CALCULATED
        if(dp[ind1][ind2]!=-1) {
            return dp[ind1][ind2];
        }

        // 4. MATCH - TAKE BOTH + DIAGONAL + 1
        if(s1.charAt(ind1)==s2.charAt(ind2)) {
            return dp[ind1][ind2]=1+func(s1,s2,ind1-1,ind2-1,dp);
        }

        // 5. NO MATCH - TWO CHOICES + MAX
        return dp[ind1][ind2]=Math.max(
            func(s1,s2,ind1,ind2-1,dp),
            func(s1,s2,ind1-1,ind2,dp)
        );
    }

    public int lcs(String str1,String str2) {
        int n=str1.length();
        int m=str2.length();

        // 6. CREATE 2D DP + INITIALIZE -1
        int[][] dp=new int[n][m];
        for(int[] row:dp) {
            Arrays.fill(row,-1);
        }

        // 7. START FROM LAST INDEXES
        return func(str1,str2,n-1,m-1,dp);
    }
}
---------------Tabu-----------------------------
import java.util.*;

class Solution {
    public int lcs(String str1,String str2) {
        int n=str1.length();
        int m=str2.length();

        // 1. CREATE DP WITH SHIFTED INDEXES
        int[][] dp=new int[n+1][m+1];

        // 2. BASE CASE - FIRST ROW AND COLUMN = 0
        for(int i=0;i<=n;i++) {
            dp[i][0]=0;
        }

        for(int j=0;j<=m;j++) {
            dp[0][j]=0;
        }

        // 3. TRAVERSE FROM 1 TO N AND 1 TO M
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {

                // 4. MATCH - DIAGONAL + 1
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                }

                // 5. NO MATCH - MAX OF UP AND LEFT
                else {
                    dp[i][j]=Math.max(
                        dp[i-1][j],
                        dp[i][j-1]
                    );
                }
            }
        }

        // 6. RETURN FINAL ANSWER
        return dp[n][m];
    }
}
------------------Space optimisation---------------------------------------
import java.util.*;
class Solution {
    public int lcs(String str1,String str2) {
        int n=str1.length();
        int m=str2.length();

        // 1. CREATE PREVIOUS ROW
        int[] prev=new int[m+1];

        // 2. TRAVERSE ROW BY ROW
        for(int i=1;i<=n;i++) {

            // 3. CREATE CURRENT ROW
            int[] curr=new int[m+1];

            for(int j=1;j<=m;j++) {

                // 4. MATCH - DIAGONAL + 1
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    curr[j]=1+prev[j-1];
                }

                // 5. NO MATCH - MAX OF UP AND LEFT
                else {
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }

            // 6. MOVE CURRENT ROW TO PREVIOUS
            prev=curr;
        }

        // 7. RETURN FINAL ANSWER
        return prev[m];
    }
}
