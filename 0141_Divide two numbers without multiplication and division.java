class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE; // handle overflow

        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        int sign=((dividend<0)^(divisor<0))?-1:1; // determine sign
        long quotient=0;

        while(a>=b) {
            long temp=b;
            long count=1; // start with one divisor

            while(a>=(temp<<1)) {
                temp<<=1; // double divisor
                count<<=1; // double quotient contribution
            }

            a-=temp; // subtract largest fitting multiple
            quotient+=count; // add its contribution
        }

        return (int)(sign*quotient);
    }
}
