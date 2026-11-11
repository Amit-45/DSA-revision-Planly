----------------------RECUR--------------------------------------
class Solution {
    private boolean isAllStars(String pat,int i) {
        for(int j=0;j<=i;j++) {
            if(pat.charAt(j)!='*')
                return false;
        }
        return true;
    }

    private boolean func(String pat,String str,int i,int j) {
        // Both exhausted → Match successful
        if(i<0 && j<0)
            return true;

        // Pattern exhausted but string remains → No match
        if(i<0)
            return false;

        // String exhausted → Remaining pattern must contain only *
        if(j<0)
            return isAllStars(pat,i);

        // Match OR ? → Move both indexes
        if(pat.charAt(i)==str.charAt(j) || pat.charAt(i)=='?')
            return func(pat,str,i-1,j-1);

        // * → Either match empty OR consume one string character
        if(pat.charAt(i)=='*')
            return func(pat,str,i-1,j) || func(pat,str,i,j-1);

        // Normal character mismatch
        return false;
    }

    public boolean wildCard(String str,String pat) {
        int n=str.length();
        int m=pat.length();

        return func(pat,str,m-1,n-1);
    }
}
----------------MEMO------------------------------------
import java.util.*;

class Solution {
    private boolean isAllStars(String pat,int i) {
        for(int j=0;j<=i;j++) {
            if(pat.charAt(j)!='*')
                return false;
        }
        return true;
    }

    private boolean func(String pat,String str,int i,int j,int[][] dp) {
        if(i<0 && j<0)
            return true;

        if(i<0)
            return false;

        if(j<0)
            return isAllStars(pat,i);

        if(dp[i][j]!=-1)
            return dp[i][j]==1;

        if(pat.charAt(i)==str.charAt(j) || pat.charAt(i)=='?')
            dp[i][j]=func(pat,str,i-1,j-1,dp)?1:0;

        else if(pat.charAt(i)=='*')
            dp[i][j]=(func(pat,str,i-1,j,dp) || func(pat,str,i,j-1,dp))?1:0;

        else
            dp[i][j]=0;

        return dp[i][j]==1;
    }

    public boolean wildCard(String str,String pat) {
        int n=str.length();
        int m=pat.length();

        int[][] dp=new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        return func(pat,str,m-1,n-1,dp);
    }
}
-----------------SPACE OPTI------------------------------------
class Solution {
    private boolean isAllStars(String pat,int i) {
        for(int j=0;j<=i;j++) {
            if(pat.charAt(j)!='*')
                return false;
        }
        return true;
    }

    public boolean wildCard(String str,String pat) {
        int n=str.length();
        int m=pat.length();

        boolean[] prev=new boolean[n+1];
        boolean[] cur=new boolean[n+1];

        prev[0]=true;

        for(int i=1;i<=m;i++) {
            cur[0]=isAllStars(pat,i-1);

            for(int j=1;j<=n;j++) {
                if(pat.charAt(i-1)==str.charAt(j-1) || pat.charAt(i-1)=='?')
                    cur[j]=prev[j-1];

                else if(pat.charAt(i-1)=='*')
                    cur[j]=prev[j] || cur[j-1];

                else
                    cur[j]=false;
            }

            prev=cur.clone();
        }

        return prev[n];
    }
}
