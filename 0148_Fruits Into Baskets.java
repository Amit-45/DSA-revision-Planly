
import java.util.*;

class Solution {
    public int totalFruits(int[] fruits) {
        // Initialize window pointers, maximum length and fruit counts
        int l=0,r=0,maxLen=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();

        while(r<fruits.length) {
            // Expand window: add the incoming fruit and update its count
            mpp.put(fruits[r],mpp.getOrDefault(fruits[r],0)+1);

            // Handle invalid window: more than 2 distinct fruit types
            if(mpp.size()>2) {
                // Decrease the count of the outgoing leftmost fruit
                mpp.put(fruits[l],mpp.get(fruits[l])-1);

                // Remove fruit type if no occurrences remain
                if(mpp.get(fruits[l])==0)
                    mpp.remove(fruits[l]);

                // Shrink window by moving the left pointer forward
                l++;
            }

            // Update maximum length when the window is valid
            if(mpp.size()<=2)
                maxLen=Math.max(maxLen,r-l+1);

            // Move right pointer to process the next tree
            r++;
        }

        // Return the maximum number of fruits collected
        return maxLen;
    }
}
