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
        int largestArea=0;

        // Traverse: Go left to right
        for(int i=0;i<n;i++) {
            // Pop: Current height is smaller or equal to stack top
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                int ind=st.pop();

                // NSE: Current index; PSE: New stack top
                int nse=i;
                int pse=st.isEmpty() ? -1 : st.peek();

                // Area: Height × Width
                int width=nse-pse-1;
                int area=heights[ind]*width;

                // Update: Store maximum area
                largestArea=Math.max(largestArea,area);
            }

            // Push: Store current index
            st.push(i);
        }

        // Remaining bars: NSE is n
        while(!st.isEmpty()) {
            int ind=st.pop();
            int nse=n;
            int pse=st.isEmpty() ? -1 : st.peek();

            // Area: Height × Width
            int width=nse-pse-1;
            int area=heights[ind]*width;

            // Update: Store maximum area
            largestArea=Math.max(largestArea,area);
        }

        // Return: Largest rectangle area
        return largestArea;
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
