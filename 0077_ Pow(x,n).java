class Solution {
    public double myPow(double x,int n) {
        //NEGATIVE NUMBERS
        long y=n;
        if(y<0) {
            x=1/x; 
            y=-y; 
        }
        return power(x,y);
    }

    private double power(double x,long y) {
        if(y==0)return 1;

        double half=power(x,y/2); 

        if(y%2==0)return half*half; //EVEN
        return half*half*x; //ODD
    }
}
