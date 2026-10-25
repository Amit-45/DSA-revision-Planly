class Solution {
    private int XORtillN(int n) {
        // Pattern: result depends on n % 4
        if(n%4==1)return 1;
        if(n%4==2)return n+1;
        if(n%4==3)return 0;
        return n; // n % 4 == 0
    }

    public int findRangeXOR(int l,int r) {
        // Range XOR = prefix before L ^ prefix till R
        return XORtillN(l-1)^XORtillN(r);
    }
}
