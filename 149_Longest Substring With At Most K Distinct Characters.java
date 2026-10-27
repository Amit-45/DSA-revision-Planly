
import java.util.*;

class Solution {
    public int kDistinctChar(String s,int k) {
        int l=0,r=0,maxLen=0;
        HashMap<Character,Integer> mpp=new HashMap<>();

        while(r<s.length()) {
            // 1. Expand window: add incoming character
            char charR=s.charAt(r);
            mpp.put(charR,mpp.getOrDefault(charR,0)+1);

            // 2. Handle invalid window: too many distinct characters
            if(mpp.size()>k) {
                // 3. Decrease outgoing character frequency
                char charL=s.charAt(l);
                mpp.put(charL,mpp.get(charL)-1);

                // 4. Remove character if count becomes zero
                if(mpp.get(charL)==0)
                    mpp.remove(charL);

                // 5. Shrink window from left
                l++;
            }

            // 6. Update maximum valid window length
            if(mpp.size()<=k)
                maxLen=Math.max(maxLen,r-l+1);

            // 7. Move right to the next character
            r++;
        }

        // 8. Return answer
        return maxLen;
    }
}
