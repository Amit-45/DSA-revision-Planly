import java.util.*;

class Solution {

    public int[] findOrder(int n,int[][] prerequisites) {

        // CREATE GRAPH
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        // BUILD GRAPH: b → a
        for(int[] it:prerequisites) {
            adj.get(it[1]).add(it[0]);
        }

        // CREATE INDEGREE + ANSWER
        int[] inDegree=new int[n];
        int[] ans=new int[n];

        // CALCULATE INDEGREE
        for(int i=0;i<n;i++) {
            for(int it:adj.get(i)) {
                inDegree[it]++;
            }
        }

        // CREATE QUEUE + ADD ZERO INDEGREE
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(inDegree[i]==0) q.add(i);
        }

        // PROCESS QUEUE
        int index=0;
        while(!q.isEmpty()) {
            // POLL + STORE IN ANSWER
            int node=q.poll();
            ans[index++]=node;

            // DECREASE NEIGHBOURS' INDEGREE
            for(int it:adj.get(node)) {
                inDegree[it]--;

                // ZERO INDEGREE → ENQUEUE
                if(inDegree[it]==0) q.add(it);
            }
        }

        // CYCLE → EMPTY ARRAY
        if(index<n) return new int[0];

        // RETURN COURSE ORDER
        return ans;
    }
}
