-------------Brute-------------------------------------------
class Solution {
    public int stockBuySell(int[] arr,int n) {
        int maxProfit=0;
        // Try every possible buying day
        for(int i=0;i<n;i++) {
            // Try every selling day after buying day
            for(int j=i+1;j<n;j++) {
                // Calculate profit
                int profit=arr[j]-arr[i];
                // Update maximum profit
                maxProfit=Math.max(maxProfit,profit);
            }
        }
        return maxProfit;
    }
}
---------GREEDY is the optimal--------------------------------
class Solution {
    public int stockBuySell(int[] arr,int n) {
        int maxProfit=0; // Stores maximum profit
        int mini=arr[0]; // Stores minimum buying price so far
        // Traverse the array from the second day
        for(int i=1;i<n;i++) {
            // Calculate profit if we sell the stock today
            int curProfit=arr[i]-mini;
            // Update maximum profit
            maxProfit=Math.max(maxProfit,curProfit);
            // Update minimum buying price for future days
            mini=Math.min(mini,arr[i]);
        }
        // Return the maximum profit
        return maxProfit;
    }
}


