import java.util.Stack;
class Solution {
    private boolean isMatched(char open, char close) {
        return (open=='(' && close==')') ||
               (open=='[' && close==']') ||
               (open=='{' && close=='}');
    }
    public boolean isValid(String str) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++) {
            char ch=str.charAt(i);
            // If opening bracket → Store in stack
            if(ch=='(' || ch=='[' || ch=='{') {
                st.push(ch);
            }
            // If closing bracket and stack is empty → No corresponding opening → Return false
            else if(st.isEmpty()) {
                return false;
            }
            // If closing bracket and stack is not empty → Get top element
            else {
                char top=st.peek();
                // If matching → Pop top element and move ahead
                if(isMatched(top,ch)) {
                    st.pop();
                }
                // If not matching → Return false
                else {
                    return false;
                }
            }
        }
        // If stack is empty → All brackets matched → Return true
        return st.isEmpty();
    }
}
