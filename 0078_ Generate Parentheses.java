import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(0,0,n,"",result);
        return result;
    }

    private void backtrack(int open,int close,int n,String current,List<String> result) {
        // 1. When should I stop? Both opening and closing counts reach n
        if(open==n && close==n) {
            result.add(current);
            return;
        }

        // 2. Add '(' if opening brackets are available
        if(open<n)
            backtrack(open+1,close,n,current+'(',result);

        // 3. Add ')' if an opening bracket is waiting to be closed
        if(close<open)
            backtrack(open,close+1,n,current+')',result);
    }
}
