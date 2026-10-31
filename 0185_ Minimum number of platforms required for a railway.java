import java.util.*;
class Solution {
    public int findPlatform(int[] Arrival,int[] Departure) {
        int n=Arrival.length;
        // Sort both arrival and departure arrays
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        // Initialize platform count and pointers
        int ans=1,count=1;
        int i=1,j=0;
        // Compare next arrival with next departure
        while(i<n && j<n) {
            if(Arrival[i]<=Departure[j]) {
                count++; // Arrival: Occupy a platform
                i++;
            } else {
                count--; // Departure: Free a platform
                j++;
            }
            ans=Math.max(ans,count); // Update maximum platforms
        }
        return ans; // Return minimum platforms required
    }
}
