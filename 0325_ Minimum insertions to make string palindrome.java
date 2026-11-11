-----------------TABU---------------------------------
class Solution {
    private int lcs(String s1,String s2) {
        int n=s1.length();
        int m=s2.length();

        // Create dp array to store LCS results
        int[][] dp=new int[n+1][m+1];

        // First row and column are already 0 (base case)

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {

                // Match → Add 1 to diagonal previous result
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];

                // No match → Skip one character from either string
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        // Return LCS length
        return dp[n][m];
    }
    public int minInsertion(String s) {
        // Reverse string → LPS = LCS(original, reverse)
        String t=new StringBuilder(s).reverse().toString();

        int n=s.length();
        int lps=lcs(s,t);

        // Minimum insertions = original length - LPS length
        return n-lps;
    }
}
