class Solution {
    // Function to reverse the string 
    public void reverseString(List<Character> s) {
        int start = 0, end = s.size() - 1;

        // Until the string is reversed
        while (start < end) {
            // Swap the characters at start and end
            char ch = s.get(start);
            s.set(start, s.get(end));
            s.set(end, ch);

            // Move the pointers towards the center
            start++;
            end--;
        }
    }
}
