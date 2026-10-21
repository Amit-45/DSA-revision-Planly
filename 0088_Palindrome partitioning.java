import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backtrack(0,s,new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int index,String s,List<String> path,List<List<String>> res) {
        // STOP: Have I reached the end? Save this partition.
        if(index==s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // TRY: Every possible ending position i.
        for(int i=index;i<s.length();i++) {
            // CHECK: Is s[index...i] a palindrome? If not, skip.
            if(isPalindrome(s,index,i)) {
                // TAKE: Add this palindrome to my path.
                path.add(s.substring(index,i+1));

                // RECURSE: Now solve the remaining string from i+1.
                backtrack(i+1,s,path,res);

                // BACKTRACK: Remove my last choice and try another substring.
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end) {
        // CHECK: Compare characters from both ends.
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}
