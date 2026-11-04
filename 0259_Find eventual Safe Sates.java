import java.util.*;
class Solution {
    public List<Integer> eventualSafeNodes(int V,List<List<Integer>> adj) {

        // CREATE REVERSE GRAPH + OUTDEGREE
        List<List<Integer>> revAdj=new ArrayList<>();
        int[] outDegree=new int[V];

        for(int i=0;i<V;i++) {
            revAdj.add(new ArrayList<>());
        }

        // REVERSE EDGES + CALCULATE OUTDEGREE
        for(int i=0;i<V;i++) {
            outDegree[i]=adj.get(i).size();

            for(int it:adj.get(i)) {
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

        // SORT ANSWER + RETURN
        Collections.sort(ans);
        return ans;
    }
}
