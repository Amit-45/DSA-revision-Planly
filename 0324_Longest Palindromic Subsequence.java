-------------------TABU--------------------------
class Solution {
    public int longestPalinSubseq(String s) {
        String t=new StringBuilder(s).reverse().toString();

        int n=s.length();
        int[][] dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}
------------------Space --------------------------
class Solution {
    private int lcs(String s1,String s2) {
        int n=s1.length();
        int m=s2.length();

        int[] prev=new int[m+1];
        int[] cur=new int[m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    cur[j]=1+prev[j-1];
                else
                    cur[j]=Math.max(prev[j],cur[j-1]);
            }
            System.arraycopy(cur,0,prev,0,m+1);
        }

        return prev[m];
    }

    public int longestPalinSubseq(String s) {
        String t=new StringBuilder(s).reverse().toString();
        return lcs(s,t);
    }
}
