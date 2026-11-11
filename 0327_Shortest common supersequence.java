
import java.util.*;

class Solution {
    public String shortestCommonSupersequence(String str1,String str2) {
        int n=str1.length();
        int m=str2.length();

        // 1. Create DP table to store LCS lengths
        int[][] dp=new int[n+1][m+1];

        // 2. First row and column = 0 (base cases)

        // 3. Fill DP table using LCS recurrence
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        // 4. Start from bottom-right to reconstruct SCS
        int i=n;
        int j=m;
        StringBuilder ans=new StringBuilder();

        while(i>0 && j>0) {

            // 5. Match → Add character once and move diagonally
            if(str1.charAt(i-1)==str2.charAt(j-1)) {
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }

            // 6. No match → Take character from the direction with greater LCS value
            else if(dp[i-1][j]>dp[i][j-1]) {
                ans.append(str1.charAt(i-1));
                i--;
            } else {
                ans.append(str2.charAt(j-1));
                j--;
            }
        }

        // 7. Add remaining characters from either string
        while(i>0) {
            ans.append(str1.charAt(i-1));
            i--;
        }

        while(j>0) {
            ans.append(str2.charAt(j-1));
            j--;
        }

        // 8. Reverse because we built the answer backwards
        return ans.reverse().toString();
    }
}
