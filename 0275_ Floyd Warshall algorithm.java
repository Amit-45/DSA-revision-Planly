class Solution {
    public void shortestDistance(int[][] matrix) {

        // GET NUMBER OF NODES
        int n=matrix.length;

        // K = INTERMEDIATE NODE
        for(int k=0;k<n;k++) {

            // I = SOURCE NODE
            for(int i=0;i<n;i++) {

                // J = DESTINATION NODE
                for(int j=0;j<n;j++) {

                    // IF PATH VIA K IS NOT POSSIBLE → SKIP
                    if(matrix[i][k]==-1 || matrix[k][j]==-1) continue;

                    // NEW DISTANCE = I TO K + K TO J
                    int newDist=matrix[i][k]+matrix[k][j];

                    // NO DIRECT PATH → ASSIGN NEW DISTANCE
                    if(matrix[i][j]==-1) matrix[i][j]=newDist;

                    // OTHERWISE → TAKE MINIMUM DISTANCE
                    else matrix[i][j]=Math.min(matrix[i][j],newDist);
                }
            }
        }
    }
}
