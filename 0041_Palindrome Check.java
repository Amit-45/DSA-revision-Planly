class Solution {
    // Function to check if a given string is a palindrome
    public boolean palindromeCheck(String s) {
        int left = 0;               
        int right = s.length() - 1; 

        // Iterate while start pointer is less than end pointer
        while (left < right) {
            // If characters  don't match, it's not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;   
            right--;  
        }
        return true; 
    }
}
