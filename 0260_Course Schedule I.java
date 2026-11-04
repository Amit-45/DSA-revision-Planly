import java.util.*;

class Solution {

    private int[] topoSort(int V,ArrayList<Integer>[] adj) {
        // CREATE INDEGREE + ANSWER
        int[] inDegree=new int[V];
        int[] ans=new int[V];

        // CALCULATE INDEGREE
        for(int i=0;i<V;i++) {
            for(int it:adj[i]) {
                inDegree[it]++;
            }
        }

        // CREATE QUEUE + ADD ZERO INDEGREE NODES
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(inDegree[i]==0) q.add(i);
        }

        // INITIALIZE INDEX
        int index=0;

        // PROCESS QUEUE
        while(!q.isEmpty()) {
            // POLL NODE + STORE IN ANSWER
            int node=q.poll();
            ans[index++]=node;

            // DECREASE NEIGHBOURS' INDEGREE
            for(int it:adj[node]) {
                inDegree[it]--;

                // ZERO INDEGREE → ENQUEUE
                if(inDegree[it]==0) q.add(it);
            }
        }

        // RETURN PROCESSED NODES
        return Arrays.copyOfRange(ans,0,index);
    }

    public boolean canFinish(int N,int[][] arr) {
        // CREATE ADJACENCY LIST
        ArrayList<Integer>[] adj=new ArrayList[N];
        for(int i=0;i<N;i++) {
            adj[i]=new ArrayList<>();
        }

        // BUILD GRAPH: b → a
        for(int[] it:arr) {
            int a=it[0],b=it[1];
            adj[b].add(a);
        }

        // CALL TOPO SORT
        int[] topo=topoSort(N,adj);

        // ALL COURSES PROCESSED? 
        return topo.length==N;
    }
}
