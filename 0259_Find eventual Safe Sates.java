import java.util.*;

class Solution {
    public int[] eventualSafeNodes(int V,int[][] adj) {

        // CREATE REVERSE GRAPH + OUTDEGREE
        List<List<Integer>> revAdj=new ArrayList<>();
        int[] outDegree=new int[V];

        for(int i=0;i<V;i++) {
            revAdj.add(new ArrayList<>());
        }

        // REVERSE EDGES + CALCULATE OUTDEGREE
        for(int i=0;i<V;i++) {
            outDegree[i]=adj[i].length;

            for(int it:adj[i]) {
                revAdj.get(it).add(i);
            }
        }

        // CREATE QUEUE + ADD TERMINAL NODES
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(outDegree[i]==0) q.add(i);
        }

        // CREATE ANSWER
        List<Integer> ans=new ArrayList<>();

        // PROCESS QUEUE
        while(!q.isEmpty()) {
            // POLL NODE + MARK SAFE
            int node=q.poll();
            ans.add(node);

            // CHECK REVERSED NEIGHBOURS
            for(int it:revAdj.get(node)) {

                // DECREASE OUTDEGREE
                outDegree[it]--;

                // ZERO OUTDEGREE → ENQUEUE
                if(outDegree[it]==0) q.add(it);
            }
        }

        // SORT ANSWER
        Collections.sort(ans);

        // CONVERT LIST TO ARRAY
        int[] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            result[i]=ans.get(i);
        }

        return result;
    }
}
