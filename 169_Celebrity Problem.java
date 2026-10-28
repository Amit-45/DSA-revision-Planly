import java.util.*;

class Solution {
    public int celebrity(int[][] M) {
        int n=M.length;

        // 1. Initialize: Set top and down pointers
        int top=0,down=n-1;

        // 2. Compare: Check whether top and down know each other
        while(top<down) {

            // 3. Eliminate: If top knows down, eliminate top
            if(M[top][down]==1) {
                top++;
            }
            // If down knows top, eliminate down
            else if(M[down][top]==1) {
                down--;
            }
            // If neither knows the other, eliminate both
            else {
                top++;
                down--;
            }
        }

        // 4. Find Candidate: Check if a candidate remains
        if(top>down) return -1;

        // 5. Verify Candidate: Check both celebrity conditions
        for(int i=0;i<n;i++) {
            if(i==top) continue;

            // Candidate must know nobody, and everyone must know candidate
            if(M[top][i]==1 || M[i][top]==0) return -1;
        }

        // 6. Return: Return celebrity index
        return top;
    }
}
