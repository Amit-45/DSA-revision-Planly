class Solution {
    public String longestCommonPrefix(String[] v) {
        if (v.length == 0) return "";
        for (int i = 0; i < v[0].length(); i++) {
            char ch = v[0].charAt(i);
            for (int j = 1; j < v.length; j++) {
                if (i == v[j].length() || v[j].charAt(i) != ch) {
                    return v[0].substring(0, i);
                }
            }
        }
        
        // If all characters match, the first string itself is the longest common prefix
        return v[0];
    }
}
