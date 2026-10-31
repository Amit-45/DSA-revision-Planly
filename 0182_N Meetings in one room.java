import java.util.*;
class Solution {
    class Meeting {
        int start,end,pos;
        Meeting(int start,int end,int pos) {
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
    public int maxMeetings(int[] start,int[] end) {
        int n=start.length;
        Meeting[] meetings=new Meeting[n];
        // Store start, end and original position
        for(int i=0;i<n;i++) {
            meetings[i]=new Meeting(start[i],end[i],i+1);
        }
        // Sort by ending time (ascending)
        Arrays.sort(meetings,(a,b)->a.end-b.end);
        int count=1;
        int freeTime=meetings[0].end;
        // Check remaining meetings
        for(int i=1;i<n;i++) {
            if(meetings[i].start>freeTime) {
                count++;                     // Select meeting
                freeTime=meetings[i].end;    // Update room availability
            }
        }
        return count;
    }
}
