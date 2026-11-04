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
--------------------------------Levelwise BFS + Reverse DFS+ Distance HashMap + Backtracking (Preferred) -----------------------------------------------------------------------------
import java.util.*;

class Solution {

    public List<List<String>> findSequences(String beginWord,String endWord,List<String> wordList) {
        Set<String> st=new HashSet<>(wordList); // HASHSET
        Map<String,Integer> dist=new HashMap<>(); // DISTANCE MAP
        Queue<String> q=new LinkedList<>(); // BFS QUEUE

        if(!st.contains(endWord)) return new ArrayList<>();

        q.add(beginWord); // ADD SOURCE
        st.remove(beginWord);
        dist.put(beginWord,1); // START DISTANCE

        while(!q.isEmpty()) {
            String word=q.poll(); // POLL WORD
            int steps=dist.get(word); // GET DISTANCE

            for(int i=0;i<word.length();i++) {
                char[] arr=word.toCharArray();

                for(char ch='a';ch<='z';ch++) {
                    arr[i]=ch; // TRY a-z
                    String newWord=new String(arr);

                    if(st.contains(newWord)) { // HASHSET CHECK
                        dist.put(newWord,steps+1); // STORE DISTANCE
                        q.add(newWord); // ENQUEUE
                        st.remove(newWord); // MARK VISITED
                    }
                }
            }
        }

        List<List<String>> ans=new ArrayList<>();
        List<String> seq=new ArrayList<>();
        seq.add(endWord); // START DFS FROM TARGET

        dfs(endWord,beginWord,seq,dist,ans);

        return ans;
    }

    private void dfs(String word,String beginWord,List<String> seq,
                     Map<String,Integer> dist,List<List<String>> ans) {

        if(word.equals(beginWord)) { // CHECK SOURCE
            List<String> path=new ArrayList<>(seq);
            Collections.reverse(path); // REVERSE PATH
            ans.add(path); // STORE ANSWER
            return;
        }

        int steps=dist.get(word); // CURRENT DISTANCE

        for(int i=0;i<word.length();i++) {
            char[] arr=word.toCharArray();

            for(char ch='a';ch<='z';ch++) {
                arr[i]=ch; // TRY a-z
                String newWord=new String(arr);

                if(dist.containsKey(newWord) &&
                   dist.get(newWord)==steps-1) { // PREVIOUS LEVEL CHECK

                    seq.add(newWord); // ADD PREVIOUS WORD
                    dfs(newWord,beginWord,seq,dist,ans); // RECURSE
                    seq.remove(seq.size()-1); // BACKTRACK
                }
            }
        }
    }
}
