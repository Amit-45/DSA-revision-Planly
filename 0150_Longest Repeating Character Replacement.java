import java.util.*;
//BETTER SOLUTION -> OPTIMISED SOLUTION -> Remove while loop and replace it with if AND  remove Max Frequency Recalculation
class Solution {
    public int characterReplacement(String s,int k) {
        // 1. Initialize maximum length, max frequency and window pointers
        int maxLen=0,maxFreq=0;
        int l=0,r=0;

        // 2. Initialize frequency array for 26 uppercase letters
        int[] hash=new int[26];

        while(r<s.length()) {
            // 3. Expand window: count the incoming character
            hash[s.charAt(r)-'A']++;

            // 4. Update maximum character frequency
            maxFreq=Math.max(maxFreq,hash[s.charAt(r)-'A']);

            // 5. Check validity: replacements needed must be <= k
            while((r-l+1)-maxFreq>k) {
                // 6. Shrink window: remove the outgoing character
                hash[s.charAt(l)-'A']--;

                // 7. Recalculate maximum frequency in the window
                maxFreq=0;
                for(int i=0;i<26;i++)
                    maxFreq=Math.max(maxFreq,hash[i]);

                l++;
            }

            // 8. Update maximum valid substring length
            maxLen=Math.max(maxLen,r-l+1);

            // 9. Move right pointer to expand window
            r++;
        }

        // 10. Return the longest valid substring length
        return maxLen;
    }}
