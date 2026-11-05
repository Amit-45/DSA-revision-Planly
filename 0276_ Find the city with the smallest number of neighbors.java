import java.util.*;

class Solution {
    public int findCity(int n,int m,int[][] edges,int distanceThreshold) {

        // BUILD MATRIX → INITIALIZE INFINITY
        int[][] adjMat=new int[n][n];
        for(int[] row:adjMat) Arrays.fill(row,(int)1e9);

        // STORE BIDIRECTIONAL EDGES
        for(int[] it:edges) {
            int u=it[0],v=it[1],wt=it[2];
            adjMat[u][v]=wt;
            adjMat[v][u]=wt;
        }

        // FLOYD WARSHALL → VIA → SRC → DEST
        for(int via=0;via<n;via++) {
            for(int src=0;src<n;src++) {
                for(int dest=0;dest<n;dest++) {

                    // NEW DIST = SRC TO VIA + VIA TO DEST
                    adjMat[src][dest]=Math.min(adjMat[src][dest],adjMat[src][via]+adjMat[via][dest]);
                }
            }
        }

        // INITIALIZE MINIMUM COUNT AND ANSWER
        int minCount=(int)1e9;
        int ans=-1;

        // CHECK EVERY CITY
        for(int i=0;i<n;i++) {

            // COUNT REACHABLE NEIGHBOURS
            int count=0;
            for(int j=0;j<n;j++) {

                // EXCLUDE SELF → CHECK THRESHOLD
                if(i!=j && adjMat[i][j]<=distanceThreshold) {
                    count++;
                }
            }

            // SMALLER COUNT → UPDATE MINIMUM AND ANSWER
            if(count<minCount) {
                minCount=count;
                ans=i;
            }

            // EQUAL COUNT → CHOOSE GREATER INDEX
            else if(count==minCount) {
                ans=i;
            }
        }

        // RETURN CITY
        return ans;
    }
}
