import java.util.*;

class Solution {
    public String removeKdigits(String nums,int k) {
        Stack<Character> st=new Stack<>();

        // 1. Traverse: Process each digit
        for(int i=0;i<nums.length();i++) {
            char digit=nums.charAt(i);

            // 2. Pop: Remove larger previous digits if removals are available
            while(!st.isEmpty() && k>0 && st.peek()>digit) {
                st.pop();
                k--;
            }

            // 3. Push: Add the current digit
            st.push(digit);
        }

        // 4. Remaining Removals: Remove digits from the end
        while(!st.isEmpty() && k>0) {
            st.pop();
            k--;
        }

        // 5. Edge Case: If no digits remain, return "0"
        if(st.isEmpty()) return "0";

        // 6. Build Result: Pop digits into a string
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()) {
            res.append(st.pop());
        }

        // 7. Remove Leading Zeros: Zeros appear at the end before reversing
        while(res.length()>0 && res.charAt(res.length()-1)=='0') {
            res.deleteCharAt(res.length()-1);
        }

        // 8. Reverse: Restore the original digit order
        res.reverse();

        // 9. Final Edge Case: If only zeros remained, return "0"
        if(res.length()==0) return "0";

        // 10. Return: Smallest possible number
        return res.toString();
    }
}
