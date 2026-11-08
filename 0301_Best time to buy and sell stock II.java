---------------------RECUR---------------------------------------
buy=0 → Can buy or skip.
buy=1 → Can sell or skip.
Buying → Subtract price: -arr[ind] because money goes out of our pocket.
Selling → Add price: +arr[ind] because money comes into our pocket.
ind+1 → Move to the next day after making a choice.
n → Total number of days; it does not change.
arr → Same input price array; it does not change.
Return maximum → Choose the better profit between the two choices using Math.max().
----------------------------RECUR CODE-----------------------------------------------
class Solution {
    private int func(int ind,int buy,int n,int[] arr) {
        // Base case
        if(ind==n) return 0;

        int profit=0;

        // We can buy
        if(buy==0) {
            int buyStock=-arr[ind]+func(ind+1,1,n,arr);
            int skip=func(ind+1,0,n,arr);

            profit=Math.max(buyStock,skip);
        }

        // We can sell
        else {
            int sellStock=arr[ind]+func(ind+1,0,n,arr);
            int skip=func(ind+1,1,n,arr);

            profit=Math.max(sellStock,skip);
        }

        return profit;
    }

    public int stockBuySell(int[] arr,int n) {
        return func(0,0,n,arr);
    }
}
