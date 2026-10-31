//Same as N meeting rooms : >= AND return (n-count) is difference
import java.util.*;
class Solution {
    public int MaximumNonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]); // Sort by ending time
        int n=intervals.length;
        int cnt=1,lastEndTime=intervals[0][1];

        for(int i=1;i<n;i++) {
            if(intervals[i][0]>=lastEndTime) {
                cnt++;                       // Select interval
                lastEndTime=intervals[i][1]; // Update ending time
            }
        }
        return n-cnt; // Minimum intervals to remove
    }
}
