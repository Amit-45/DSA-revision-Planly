import java.util.*;
class Solution {
    public long solve(int[] bt) {
        Arrays.sort(bt); // Sort jobs by burst time (shortest first)
        long waitTime=0,totalTime=0;
        int n=bt.length;
        for(int i=0;i<n;i++) {
            waitTime+=totalTime; // Add previous jobs' execution time
            totalTime+=bt[i];    // Add current job's burst time
        }
        return waitTime/n; // Calculate average waiting time
    }
}
