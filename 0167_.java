Maintain a heights[] array of size M initialized to zeros.
For every row:
If cell is 1 → increase heights[j].
If cell is 0 → heights[j] = 0.
Treat the updated heights array as a histogram.
Use the stack-based Largest Rectangle in Histogram algorithm.
Track the maximum rectangle area across all rows.


---------CODE ------------------------------------------
import java.util.*;

class Solution {
    private int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;

        // Traverse: Go left to right
        for(int i=0;i<n;i++) {
            // Pop: Current height is smaller or equal to stack top
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                int h=heights[st.pop()];

                // PSE: New stack top is the previous smaller element
                int left=st.isEmpty()?-1:st.peek();

                // Calculate Area: Find width and calculate area
                int width=i-left-1;
                maxArea=Math.max(maxArea,h*width);
            }

            // Push: Store current index
            st.push(i);
        }

        // Remaining Bars: Their NSE is n
        while(!st.isEmpty()) {
            int h=heights[st.pop()];
            int left=st.isEmpty()?-1:st.peek();
            int width=n-left-1;
            maxArea=Math.max(maxArea,h*width);
        }

        // Return: Largest rectangle area
        return maxArea;
    }

    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] heights=new int[m];
        int maxArea=0;

        // Traverse: Process each row
        for(int i=0;i<n;i++) {
            // Update Heights: 1 increases height; 0 resets height
            for(int j=0;j<m;j++) {
                if(matrix[i][j]==0) heights[j]=0;
                else heights[j]++;
            }

            // Histogram: Find largest rectangle for current row
            maxArea=Math.max(maxArea,largestRectangleArea(heights));
        }

        // Return: Maximum rectangle area containing only 1s
        return maxArea;
    }
}
