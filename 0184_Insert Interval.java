MERGE INTERVAL CHEETSHEET :
1. N Meetings in One Room
- Sort by end time → Finish early to make room for more meetings.
- start > freeTime → Select; otherwise skip → Return maximum count.
2. Non-overlapping Intervals
- Sort by end time → Keep intervals that finish early.
- Overlap → Remove; no overlap → Keep → Return N - count.
3. Insert Interval
- Left → Add intervals before the new interval.
- Middle → Merge overlaps → Add merged interval → Right → Add remaining intervals.
4. Merge Intervals
- Sort by start time → Traverse intervals from left to right.
- No overlap → Add; overlap → Merge using Math.max().
-------------------------------------------------------------------------------------------------------------
import java.util.*;

class Solution {
    public int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int i=0,n=intervals.length;

        // Left segment: Add non-overlapping intervals
        while(i<n && intervals[i][1]<newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Middle segment: Merge overlapping intervals
        while(i<n && intervals[i][0]<=newInterval[1]) {
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval); // Add merged interval

        // Right segment: Add remaining non-overlapping intervals
        while(i<n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
