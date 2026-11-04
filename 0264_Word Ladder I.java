import java.util.*;
class Solution {

    // CHECK TARGET → CREATE PATTERN MAP → PREPROCESS → BFS → RETURN LEVEL
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {

        // CHECK TARGET → RETURN 0 IF ABSENT
        if(!wordList.contains(endWord)) return 0;

        // CREATE HASHMAP → PATTERN : WORDS
        Map<String,List<String>> map=new HashMap<>();

        // PREPROCESS → GENERATE PATTERNS → STORE WORDS
        for(String word:wordList) {
            for(int i=0;i<word.length();i++) {
                String pattern=word.substring(0,i)+"*"+word.substring(i+1);
                map.putIfAbsent(pattern,new ArrayList<>()); // CREATE BUCKET
                map.get(pattern).add(word); // STORE WORD
            }
        }

        // INITIALIZE BFS → QUEUE + VISITED + LEVEL
        Queue<String> q=new LinkedList<>();
        Set<String> vis=new HashSet<>();

        q.add(beginWord); // ADD SOURCE
        vis.add(beginWord); // MARK VISITED
        int level=1;

        // BFS → PROCESS LEVEL BY LEVEL
        while(!q.isEmpty()) {
            int size=q.size(); // CURRENT LEVEL SIZE

            while(size-->0) {
                String word=q.poll(); // POLL WORD

                if(word.equals(endWord)) return level; // CHECK TARGET

                // GENERATE PATTERNS → HASHMAP LOOKUP
                for(int i=0;i<word.length();i++) {
                    String pattern=word.substring(0,i)+"*"+word.substring(i+1);

                    for(String nbr:map.getOrDefault(pattern,new ArrayList<>())) {

                        // UNVISITED → MARK → ENQUEUE
                        if(!vis.contains(nbr)) {
                            vis.add(nbr);
                            q.add(nbr);
                        }
                    }

                    map.remove(pattern); // REMOVE PROCESSED PATTERN BUCKET
                }
            }

            level++; // MOVE TO NEXT LEVEL
        }

        return 0; // TARGET NOT FOUND
    }
}
