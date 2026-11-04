import java.util.*;

class Solution {

    // MARK VISITED → DFS NEIGHBOURS → PUSH NODE AFTER DFS
    private void topoSort(int node,List<List<Pair>> adj,boolean[] vis,Stack<Integer> st) {
        vis[node]=true;

        for(Pair it:adj.get(node)) {
            int v=it.first;
            if(!vis[v]) topoSort(v,adj,vis,st);
        }

        st.push(node);
    }

    // CREATE GRAPH → TOPO SORT → INIT DISTANCE → POP → RELAX → UNREACHABLE = -1 → RETURN
    public int[] shortestPath(int N,int M,int[][] edges) {

        // CREATE WEIGHTED GRAPH → STORE (NODE, WEIGHT)
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<N;i++) adj.add(new ArrayList<>());

        for(int i=0;i<M;i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        // TOPO SORT → VISITED + STACK → DFS ALL COMPONENTS
        boolean[] vis=new boolean[N];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<N;i++) {
            if(!vis[i]) topoSort(i,adj,vis,st);
        }

        // INIT DISTANCE → ALL INFINITY → SOURCE = 0
        int[] dist=new int[N];
        Arrays.fill(dist,(int)1e9);
        dist[0]=0;

        // PROCESS STACK → POP NODE
        while(!st.isEmpty()) {
            int node=st.pop();

            // SKIP UNREACHABLE NODE
            if(dist[node]==(int)1e9) continue;

            // RELAX EDGES → CURRENT DISTANCE + EDGE WEIGHT → COMPARE → UPDATE
            for(Pair it:adj.get(node)) {
                int v=it.first;
                int wt=it.second;

                if(dist[node]+wt<dist[v]) {
                    dist[v]=dist[node]+wt;
                }
            }
        }

        // UNREACHABLE NODES → INFINITY TO -1
        for(int i=0;i<N;i++) {
            if(dist[i]==(int)1e9) dist[i]=-1;
        }

        return dist; // RETURN SHORTEST DISTANCES
    }

    // STORE ADJACENT NODE + EDGE WEIGHT
    static class Pair {
        int first,second;

        Pair(int first,int second) {
            this.first=first;
            this.second=second;
        }
    }
}
