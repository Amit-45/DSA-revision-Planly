//BRUTE to OPTIMAL ->  by removing the inner loop restart and shrinking the window only when valid.
class Solution {
    public String minWindow(String s,String t) {
        int minLen=Integer.MAX_VALUE,sIndex=-1; // 1. Initialize minimum

        for(int i=0;i<s.length();i++) { // 2. Pick start
            int[] hash=new int[256];
            for(char c:t.toCharArray()) hash[c]++; // 3. Count required
            int count=0;

            for(int j=i;j<s.length();j++) { // 4. Expand window
                char ch=s.charAt(j);
                if(hash[ch]>0) count++; // 5. Match required char
                hash[ch]--; // 6. Consume character

                if(count==t.length()) { // 7. Window is valid
                    if(j-i+1<minLen) {
                        minLen=j-i+1;
                        sIndex=i; // 8. Save minimum
                    }
                    break; // 9. Stop at first valid window
                }
            }
        }
        return sIndex==-1?"":s.substring(sIndex,sIndex+minLen); // 10. Return answer
    }
}


//CHNAGES in OPTIMAL 
int[] hash=new int[256]; // Build hash once
int l=0,r=0;

while(r<s.length()) {
    // Expand right
    while(count==t.length()) {
        // Save minimum and shrink left
    }
}


Initialize: Build the hash of t once.
Expand (r): Move right and count required characters.
Shrink (l): While valid, save the minimum and shrink from the left.
Return: Extract the smallest valid substring.
