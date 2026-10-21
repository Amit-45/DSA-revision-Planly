
import java.util.*;

class Solution {
    private final String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();

        // 1. If no digits are given, there are no combinations
        if(digits.length()==0)return ans;

        // 2. Start from index 0 with an empty string
        helper(digits,ans,0,"");
        return ans;
    }

    private void helper(String digits,List<String> ans,int index,String current) {
        // 3. STOP: Have I processed all digits? Save the combination
        if(index==digits.length()) {
            ans.add(current);
            return;
        }

        // 4. Get the letters mapped to the current digit
        String s=map[digits.charAt(index)-'0'];

        // 5. TRY: Choose each possible letter for this digit
        for(int i=0;i<s.length();i++) {
            // 6. TAKE: Add this letter and move to the next digit
            helper(digits,ans,index+1,current+s.charAt(i));
        }
    }
}
