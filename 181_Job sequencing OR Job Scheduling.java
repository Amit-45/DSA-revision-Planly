import java.util.*;
class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs,(a,b)->b[2]-a[2]); // Sort by profit (descending)
        int n=Jobs.length;
        int maxDeadline=0;
        for(int[] job:Jobs) {
            maxDeadline=Math.max(maxDeadline,job[1]); // Find maximum deadline
        }
        int[] hash=new int[maxDeadline];
        Arrays.fill(hash,-1); // Initialize all slots as empty
        int cnt=0,totalProfit=0;
        for(int i=0;i<n;i++) {
            for(int j=Jobs[i][1]-1;j>=0;j--) { // Check slots from latest deadline
                if(hash[j]==-1) {
                    hash[j]=Jobs[i][0]; // Schedule the job
                    cnt++;
                    totalProfit+=Jobs[i][2]; // Add profit
                    break;
                }
            }
        }
        return new int[]{cnt,totalProfit};
    }
}
