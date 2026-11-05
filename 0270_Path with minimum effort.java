import java.util.*;

class Solution {
    int[] delRow={-1,0,1,0};
    int[] delCol={0,-1,0,1};

    boolean isValid(int row,int col,int n,int m) {
        return row>=0 && row<n && col>=0 && col<m;
    }

    public int MinimumEffort(List<List<Integer>> heights) {

        int n=heights.size(),m=heights.get(0).size();

        int[][] maxDiff=new int[n][m];
        for(int[] row:maxDiff) Arrays.fill(row,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        maxDiff[0][0]=0;
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()) {
            int[] curr=pq.poll();

            int diff=curr[0],row=curr[1],col=curr[2];

            if(row==n-1 && col==m-1) return diff;

            for(int i=0;i<4;i++) {
                int newRow=row+delRow[i];
                int newCol=col+delCol[i];

                if(isValid(newRow,newCol,n,m)) {

                    int currDiff=Math.abs(heights.get(newRow).get(newCol)-heights.get(row).get(col));

                    int newEffort=Math.max(diff,currDiff); // CHANGE 1: ADD → MAX

                    if(newEffort<maxDiff[newRow][newCol]) {
                        maxDiff[newRow][newCol]=newEffort; // CHANGE 2: UPDATE MAX EFFORT
                        pq.add(new int[]{newEffort,newRow,newCol});
                    }
                }
            }
        }

        return 0;
    }
}
