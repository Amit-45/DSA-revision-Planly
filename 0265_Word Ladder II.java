--------------Dynamic Character Replacement + HashSet + BFS + Backtracking + Level-wise Delayed Deletion---------------------------------
import java.util.*;

class Solution {
    public List<List<String>> findSequences(String beginWord,String endWord,List<String> wordList) {
        List<List<String>> ans=new ArrayList<>(); // STORE ANSWERS
        Queue<List<String>> q=new LinkedList<>(); // QUEUE OF PATHS
        Set<String> st=new HashSet<>(wordList); // CREATE HASHSET

        if(!st.contains(endWord)) return ans; // CHECK TARGET

        q.add(new ArrayList<>(Arrays.asList(beginWord))); // ADD SOURCE PATH
        st.remove(beginWord); // MARK SOURCE VISITED

        Set<String> toErase=new HashSet<>(); // DELAYED DELETION

        while(!q.isEmpty()) {
            int size=q.size(); // CURRENT LEVEL SIZE

            for(int j=0;j<size;j++) {
                List<String> seq=q.poll(); // POLL COMPLETE PATH
                String word=seq.get(seq.size()-1); // GET LAST WORD

                if(word.equals(endWord)) { // CHECK TARGET
                    ans.add(new ArrayList<>(seq)); // STORE PATH COPY
                    continue;
                }

                char[] arr=word.toCharArray(); // CONVERT TO ARRAY

                for(int i=0;i<arr.length;i++) {
                    char original=arr[i]; // SAVE ORIGINAL

                    for(char ch='a';ch<='z';ch++) {
                        arr[i]=ch; // TRY a-z
                        String newWord=new String(arr);

                        if(st.contains(newWord)) { // HASHSET CHECK
                            seq.add(newWord); // ADD TO PATH
                            q.add(new ArrayList<>(seq)); // ENQUEUE PATH COPY
                            toErase.add(newWord); // MARK FOR DELETION
                            seq.remove(seq.size()-1); // BACKTRACK
                        }
                    }

                    arr[i]=original; // RESTORE ORIGINAL
                }
            }

            for(String w:toErase) st.remove(w); // DELETE AFTER LEVEL
            toErase.clear(); // CLEAR TOERASE

            if(!ans.isEmpty()) break; // STOP AFTER SHORTEST PATHS
        }

        return ans; // RETURN ALL SHORTEST PATHS
    }
}
