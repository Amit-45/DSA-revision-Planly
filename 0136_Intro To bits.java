class Solution {
    //DECIMAL -> BINARY 
    public String decimalToBinary(int n) {
        if(n == 0) return "0";

        String result = "";

        while(n > 0) {
            if(n % 2 == 1) {
                result += '1'; // 1. Store remainder
            } else {
                result += '0';
            }
            n = n / 2; // 2. Divide by 2
        }

        result = new StringBuilder(result).reverse().toString(); // 3. Reverse result
        return result; // 4. Return binary
    }
}


-------------------------------------------------------------------

class Solution {
    public int binaryToDecimal(String str) {
        int len = str.length();
        int val = 1, num = 0;

        // 1. Start from the rightmost bit (place value = 1)
        for(int i = len - 1; i >= 0; i--) {
            // 2. If bit is '1', add its place value to num
            if(str.charAt(i) == '1') {
                num += val;
            }

            // 3. Double place value for the next bit
            val *= 2;
        }

        // 4. Return decimal equivalent
        return num;
    }
}

----------------------------------------------------------------------
Swap 2 numbers without using the third variable 
----------------------------------------------------------------------
Note: Java passes primitive int values by value. Using an array lets the swap update the original elements.
  class Solution {
    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j]; // 1. XOR both numbers
        arr[j] = arr[i] ^ arr[j]; // 2. Recover A into B
        arr[i] = arr[i] ^ arr[j]; // 3. Recover B into A
    }
}

------------------------------------------------------------------------
Check if the ith bit is set 
--------------------------------------------------------------------------
  class Solution {
    public boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0; // 1. Left Shift → AND → Check bit
    }
}

-------------------------------------------------------------------------
Set the ith bit
-------------------------------------------------------------------------
public int setBit(int n, int i) {
    return n | (1 << i); // 1. Left shift → OR → Set bit
}
--------------------------------------------------------------------------
Clear the ith bit 
--------------------------------------------------------------------------
public int clearBit(int n, int i) {
    return n & ~(1 << i); // 1. Left shift → NOT → AND → Clear bit
}
---------------------------------------------------------------------------
Toggle the ith bit 
---------------------------------------------------------------------------
    public int toggleBit(int n, int i) {
    return n ^ (1 << i); // 1. Left shift → XOR → Toggle bit
}

----------------------------------------------------------------------------
Remove the last set bit
------------------------------------------------------------------------
public int removeLastSetBit(int n) {
    return n & (n - 1); // 1. AND with n-1 → Remove rightmost set bit
}
----------------------------------------------------------------------------
Check if number is a power of 2
----------------------------------------------------------------------------
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0; // 1. Positive + remove last set bit → Check zero
}

-----------------------------------------------------------------------------
Count number of set bits(no 1 liner)
-----------------------------------------------------------------------------
public int countSetBits(int n) {
    int count = 0;
    while(n > 0) {
        n = n & (n - 1); // 1. Remove rightmost set bit
        count++; // 2. Count removed bit
    }
    return count; // 3. Return total set bits
}
---------------------------------------------------------------------------------
  
