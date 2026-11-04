-------------------DYNAMIC char replacemnet + Hashset +BFS---------------------------------------------
import java.util.*;

class Solution {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        Set<String> st=new HashSet<>(wordList); // CREATE HASHSET
        if(!st.contains(endWord)) return 0; // CHECK TARGET

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1)); // ADD SOURCE
        st.remove(beginWord); // MARK SOURCE VISITED

        while(!q.isEmpty()) {
            Pair p=q.poll(); // POLL WORD + STEPS
            String word=p.word;
            int steps=p.steps;

            if(word.equals(endWord)) return steps; // CHECK TARGET

            char[] arr=word.toCharArray(); // CONVERT TO ARRAY

            for(int i=0;i<arr.length;i++) {
                char original=arr[i]; // SAVE ORIGINAL

                for(char ch='a';ch<='z';ch++) {
                    arr[i]=ch; // TRY a-z
                    String newWord=new String(arr);

                    if(st.contains(newWord)) { // HASHSET CHECK
                        st.remove(newWord); // MARK VISITED
                        q.add(new Pair(newWord,steps+1)); // ENQUEUE
                    }
                }

                arr[i]=original; // RESTORE ORIGINAL
            }
        }
        return 0; // TARGET NOT FOUND
    }

    class Pair {
        String word;
        int steps;

        Pair(String word,int steps) {
            this.word=word;
            this.steps=steps;
        }
    }
}
-------------------------Preprocess pattern BFS + Hashmap approach -------------------------------------------------------------
import java.util.*;

class Solution {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        if(!wordList.contains(endWord)) return 0; // CHECK TARGET

        Map<String,List<String>> map=new HashMap<>(); // CREATE PATTERN MAP

        List<String> allWords=new ArrayList<>(wordList);
        allWords.add(beginWord);

        for(String word:allWords) { // PREPROCESS WORDS
            for(int i=0;i<word.length();i++) {
                String pattern=word.substring(0,i)+"*"+word.substring(i+1); // GENERATE PATTERN
                map.putIfAbsent(pattern,new ArrayList<>());
                map.get(pattern).add(word); // PATTERN → WORDS
            }
        }

        Queue<String> q=new LinkedList<>();
        Set<String> vis=new HashSet<>();

        q.add(beginWord); // ADD SOURCE
        vis.add(beginWord); // MARK VISITED

        int level=1; // INITIAL LEVEL

        while(!q.isEmpty()) {
            int size=q.size(); // CURRENT LEVEL SIZE

            while(size-->0) {
                String word=q.poll(); // POLL WORD

                if(word.equals(endWord)) return level; // CHECK TARGET

                for(int i=0;i<word.length();i++) {
                    String pattern=word.substring(0,i)+"*"+word.substring(i+1); // GENERATE PATTERN

                    List<String> neighbours=map.getOrDefault(pattern,new ArrayList<>()); // MAP LOOKUP

                    for(String nbr:neighbours) {
                        if(!vis.contains(nbr)) { // CHECK VISITED
                            vis.add(nbr); // MARK VISITED
                            q.add(nbr); // ENQUEUE
                        }
                    }

                    map.remove(pattern); // REMOVE PROCESSED BUCKET
                }
            }

            level++; // NEXT LEVEL
        }

        return 0; // TARGET NOT FOUND
    }
}
