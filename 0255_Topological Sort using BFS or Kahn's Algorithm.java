import java.util.*;
class Solution {
    public int[] topoSort(int V,List<List<Integer>> adj) {
        // CREATE ANSWER + INDEGREE
        int[] ans=new int[V];
        int[] inDegree=new int[V];

        // CALCULATE INDEGREE
        for(int i=0;i<V;i++) {
            for(int it:adj.get(i)) {
                inDegree[it]++;
            }
        }

        // CREATE QUEUE + ADD ZERO INDEGREE NODES
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(inDegree[i]==0) q.add(i);
        }

        // INITIALIZE ANSWER INDEX
        int index=0;

        // PROCESS QUEUE
        while(!q.isEmpty()) {
            // REMOVE NODE + STORE IN ANSWER
            int node=q.poll();
            ans[index++]=node;

            // DECREASE NEIGHBOURS' INDEGREE
            for(int it:adj.get(node)) {
                inDegree[it]--;

                // ZERO INDEGREE → ADD TO QUEUE
                if(inDegree[it]==0) q.add(it);
            }
        }

        // RETURN ANSWER
        return ans;
    }
}
