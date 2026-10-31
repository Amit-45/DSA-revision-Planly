class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        // Traverse each customer's bill
        for(int bill:bills) {
            // Customer pays $5: Collect it
            if(bill==5) {
                five++;
            }
            // Customer pays $10: Give $5 change
            else if(bill==10) {
                if(five>0) {
                    five--;
                    ten++;
                }
                else {
                    return false;
                }
            }
            // Customer pays $20: Give $15 change
            else {
                // First preference: Give $10 + $5
                if(five>0 && ten>0) {
                    five--;
                    ten--;
                }
                // Second preference: Give three $5 bills
                else if(five>=3) {
                    five-=3;
                }
                // Unable to provide change
                else {
                    return false;
                }
            }
        }
        // All customers received correct change
        return true;
    }
}
