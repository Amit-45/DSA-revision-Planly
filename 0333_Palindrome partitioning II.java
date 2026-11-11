----------------------RECUR(Partition DP)----------------------
class Solution {
    private boolean isPalindrome(int i,int j,String s) {
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    private int minPartitions(int i,int n,String s) {
        if(i==n)
            return 0; // No characters left

        int minCost=Integer.MAX_VALUE;

        for(int j=i;j<n;j++) { // Try all ending positions
            if(isPalindrome(i,j,s)) { // Check valid palindrome
                int cost=1+minPartitions(j+1,n,s); // Current partition + Remaining string

                minCost=Math.min(minCost,cost); // Take minimum
            }
        }
        return minCost;
    }

    public int minCut(String s) {
        int n=s.length();
        return minPartitions(0,n,s)-1; // Partitions - 1 = Cuts
    }
}
---------------------------MEMO------------------------------
import java.util.*;

class Solution {
    private boolean isPalindrome(int i,int j,String s) {
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    private int minPartitions(int i,int n,String s,int[] dp) {
        if(i==n)
            return 0; // No characters left

        if(dp[i]!=-1)
            return dp[i]; // Already calculated

        int minCost=Integer.MAX_VALUE;

        for(int j=i;j<n;j++) { // Try all ending positions
            if(isPalindrome(i,j,s)) { // Check valid palindrome
                int cost=1+minPartitions(j+1,n,s,dp); // Current + Remaining

                minCost=Math.min(minCost,cost); // Take minimum
            }
        }

        return dp[i]=minCost; // Store answer
    }

    public int minCut(String s) {
        int n=s.length();

        int[] dp=new int[n]; // One changing parameter
        Arrays.fill(dp,-1); // Initialize memo

        return minPartitions(0,n,s,dp)-1; // Partitions - 1 = Cuts
    }
}
-----------------TABUL---------------------------------
class Solution {
    private boolean isPalindrome(int i,int j,String s) {
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        int n=s.length();

        int[] dp=new int[n+1]; // Extra space for dp[j+1]
        dp[n]=0; // Base case: No characters left

        for(int i=n-1;i>=0;i--) { // Process backward
            int minCost=Integer.MAX_VALUE;

            for(int j=i;j<n;j++) { // Try all ending positions
                if(isPalindrome(i,j,s)) { // Check palindrome
                    int cost=1+dp[j+1]; // Current + Remaining

                    minCost=Math.min(minCost,cost); // Take minimum
                }
            }

            dp[i]=minCost; // Store answer
        }

        return dp[0]-1; // Partitions - 1 = Cuts
    }
}
-----------------SPACE OPTI(Not possible)----------------------------------
