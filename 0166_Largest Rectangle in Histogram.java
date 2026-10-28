--------------------OPTIMAL-----------------------------------------------------------------------------
Push: Push indices into the stack while heights are increasing.
Pop: When a smaller height appears, pop taller bars and calculate their areas.
NSE: Current index i is the Next Smaller Element index for the popped bar.
PSE: After popping, the new stack top is the Previous Smaller Element index.
Calculate Area: Find the width → Calculate the area → Update maxArea.
Remaining Bars: Use a virtual height 0 at the end to process all remaining bars.
Return: Return maxArea.

import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;

        // 1. Push: Push indices into the stack while heights are increasing
        for(int i=0;i<n;i++) {

            // 2. Pop: When a smaller height appears, pop taller bars and calculate their areas
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                int ind=st.pop();

                // 3. NSE: Current index i is the Next Smaller Element index for the popped bar
                int nse=i;

                // 4. PSE: After popping, the new stack top is the Previous Smaller Element index
                int pse=st.isEmpty()?-1:st.peek();

                // 5. Calculate Area: Find the width → Calculate the area → Update maxArea
                int width=nse-pse-1;
                int area=heights[ind]*width;
                maxArea=Math.max(maxArea,area);
            }

            st.push(i);
        }

        // 6. Remaining Bars: Use a virtual height 0 at the end to process all remaining bars
        while(!st.isEmpty()) {
            int ind=st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();

            int width=nse-pse-1;
            int area=heights[ind]*width;
            maxArea=Math.max(maxArea,area);
        }

        // 7. Return: Return maxArea
        return maxArea;
    }
}
  
-------------------BRUTE-----------------------------------------------

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length,largestArea=0;

        // Go to every bar
        for(int i=0;i<n;i++) {
            int left=i,right=i;

            // Move left until a smaller bar is found
            while(left>=0 && heights[left]>=heights[i]) left--;

            // Move right until a smaller bar is found
            while(right<n && heights[right]>=heights[i]) right++;

            // Calculate width → Calculate area
            int width=right-left-1;
            int area=heights[i]*width;

            // Update maximum area
            largestArea=Math.max(largestArea,area);
        }

        // Return largest rectangle area
        return largestArea;
    }
}
