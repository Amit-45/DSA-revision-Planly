class Solution {
    public int longestNonRepeatingSubstring(String s) {
        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        int l=0,r=0,maxLen=0,n=s.length();

        while(r<n) {
            // Check duplicate and move left
            if(hash[s.charAt(r)]!=-1)
                l=Math.max(hash[s.charAt(r)]+1,l);

            // Calculate length and update max
            maxLen=Math.max(maxLen,r-l+1);

            // Store index and move right
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxLen;
    }
}
