-------------------Tabulation (LIS Pattern + Two Pointer)--------------------------------
import java.util.*;

class Solution {
    public int longestStringChain(String[] words) {
        int n=words.length;

        // 1. SORT
        Arrays.sort(words,Comparator.comparingInt(String::length));

        // 2. DP = 1
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int maxLen=1;

        // 3. TWO LOOPS
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){

                // 4. CHECK PREDECESSOR
                if(checkPossible(words[i],words[j])){

                    // 5. UPDATE DP
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }

            // 6. UPDATE MAX
            maxLen=Math.max(maxLen,dp[i]);
        }

        // 7. RETURN MAX
        return maxLen;
    }

    // CHECK PREDECESSOR USING TWO POINTERS
    private boolean checkPossible(String s,String t){
        if(s.length()!=t.length()+1)return false;

        int i=0,j=0;

        while(i<s.length()){
            if(j<t.length() && s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        return j==t.length();
    }
}
