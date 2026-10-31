RECURSION---------------------------------------------------------
class Solution {
    private boolean checkValid(int ind,int count,String s) {
        if(count<0) return false;
        if(ind==s.length()) return count==0;

        if(s.charAt(ind)=='(')
            return checkValid(ind+1,count+1,s);
        if(s.charAt(ind)==')')
            return checkValid(ind+1,count-1,s);

        return checkValid(ind+1,count+1,s) ||
               checkValid(ind+1,count-1,s) ||
               checkValid(ind+1,count,s);
    }

    public boolean isValid(String s) {
        return checkValid(0,0,s);
    }
}

DP (Momoized solution)(Still not OPTIMAL)--------------------------------------------------------------------------
import java.util.*;
class Solution {
    private boolean checkValid(int ind,int count,String s,int[][] dp) {
        if(count<0) return false;
        if(ind==s.length()) return count==0;
        if(dp[ind][count]!=-1) return dp[ind][count]==1;

        boolean ans=false;
        if(s.charAt(ind)=='(')
            ans=checkValid(ind+1,count+1,s,dp);
        else if(s.charAt(ind)==')')
            ans=checkValid(ind+1,count-1,s,dp);
        else
            ans=checkValid(ind+1,count+1,s,dp) ||
                checkValid(ind+1,count-1,s,dp) ||
                checkValid(ind+1,count,s,dp);

        dp[ind][count]=ans?1:0;
        return ans;
    }

    public boolean isValid(String s) {
        int n=s.length();
        int[][] dp=new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return checkValid(0,0,s,dp);
    }
}
---------------OPTIMAL(GREEDY Range Tracking Approach)
  
