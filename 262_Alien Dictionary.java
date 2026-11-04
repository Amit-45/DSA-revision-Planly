class Solution {

    public String findOrder(String[] dict,int N,int K) {
        List<List<Integer>> adj=new ArrayList<>(); // CREATE GRAPH
        for(int i=0;i<K;i++) adj.add(new ArrayList<>());

        for(int i=0;i<N-1;i++) { // COMPARE CONSECUTIVE WORDS
            String s1=dict[i];
            String s2=dict[i+1];
            int len=Math.min(s1.length(),s2.length());

            boolean found=false;
            for(int j=0;j<len;j++) { // FIND FIRST DIFFERENCE
                if(s1.charAt(j)!=s2.charAt(j)) {
                    int u=s1.charAt(j)-'a';
                    int v=s2.charAt(j)-'a';
                    adj.get(u).add(v); // ADD EDGE
                    found=true;
                    break;
                }
            }

            if(!found && s1.length()>s2.length()) return ""; // INVALID PREFIX
        }

        int[] topo=topoSort(K,adj); // CALL TOPOSORT
        if(topo.length!=K) return ""; // CYCLE CHECK

        StringBuilder ans=new StringBuilder();
        for(int node:topo) ans.append((char)(node+'a')); // CONVERT TO CHARACTERS

        return ans.toString();
    }

    private int[] topoSort(int K,List<List<Integer>> adj) {
        int[] indegree=new int[K]; // CREATE INDEGREE

        for(int i=0;i<K;i++) {
            for(int it:adj.get(i)) indegree[it]++; // CALCULATE INDEGREE
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<K;i++) {
            if(indegree[i]==0) q.add(i); // ADD ZERO INDEGREE NODES
        }

        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()) {
            int node=q.poll(); // POLL
            ans.add(node); // STORE IN ANSWER

            for(int it:adj.get(node)) {
                indegree[it]--; // DECREASE NEIGHBOUR INDEGREE
                if(indegree[it]==0) q.add(it); // ZERO → ENQUEUE
            }
        }

        int[] topo=new int[ans.size()];
        for(int i=0;i<ans.size();i++) topo[i]=ans.get(i); // LIST TO ARRAY

        return topo; // RETURN TOPOLOGICAL ORDER
    }
}
