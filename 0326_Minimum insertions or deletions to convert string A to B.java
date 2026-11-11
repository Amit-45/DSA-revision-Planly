-------------------TABU------------------------------
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

    public int minOperations(String str1,String str2) {
        int n=str1.length();
        int m=str2.length();

        // Find maximum common characters to preserve
        int k=lcs(str1,str2);

        // Delete remaining from str1 + Insert remaining from str2
        return (n-k)+(m-k);
    }
}
---------------SPACE OPTI------------------------------------

class Solution {
    private int lcs(String s1,String s2) {
        int n=s1.length();
        int m=s2.length();

        // Store previous and current DP rows
        int[] prev=new int[m+1];
        int[] cur=new int[m+1];

        // Base case: both arrays initialized to 0

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {

                // Match → Take diagonal previous value + 1
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    cur[j]=1+prev[j-1];

                // No match → Maximum of above and left
                else
                    cur[j]=Math.max(prev[j],cur[j-1]);
            }

            // Current row becomes previous row for next iteration
            prev=cur.clone();
        }

        // Return final LCS length
        return prev[m];
    }

    public int minOperations(String str1,String str2) {
        int n=str1.length();
        int m=str2.length();

        // Find LCS length
        int k=lcs(str1,str2);

        // Delete remaining from str1 + Insert remaining into str1
        return (n-k)+(m-k);
    }
}
