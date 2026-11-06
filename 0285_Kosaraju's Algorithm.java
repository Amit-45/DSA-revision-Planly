import java.util.*;

class Solution {

    // STEP 1: FIRST DFS → Store nodes by finishing time.
    private void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st) {

        // Mark visited.
        vis[node]=1;

        // Explore unvisited neighbours.
        for(int it:adj.get(node)) {
            if(vis[it]==0) {
                dfs(it,vis,adj,st);
            }
        }

        // Push AFTER all neighbours are processed.
        st.push(node);
    }

    // STEP 3: SECOND DFS → Visit one SCC in reversed graph.
    private void helperDFS(int node,int[] vis,ArrayList<ArrayList<Integer>> adjT) {

        // Mark visited.
        vis[node]=1;

        // Explore unvisited neighbours.
        for(int it:adjT.get(node)) {
            if(vis[it]==0) {
                helperDFS(it,vis,adjT);
            }
        }
    }

    public int kosaraju(int V,ArrayList<ArrayList<Integer>> adj) {

        // 1. INITIALIZE VISITED & STACK.
        int[] vis=new int[V];
        Stack<Integer> st=new Stack<>();

        // 2. TRAVERSE ALL NODES → First DFS.
        for(int i=0;i<V;i++) {
            if(vis[i]==0) {
                dfs(i,vis,adj,st);
            }
        }

        // 3. INITIALIZE TRANSPOSE GRAPH.
        ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();

        for(int i=0;i<V;i++) {
            adjT.add(new ArrayList<>());
        }

        // 4. RESET VISITED & REVERSE EDGES.
        for(int i=0;i<V;i++) {

            vis[i]=0;

            // Reverse u → v into v → u.
            for(int it:adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        // 5. INITIALIZE SCC COUNT.
        int count=0;

        // 6. POP FROM STACK.
        while(!st.isEmpty()) {

            int node=st.pop();

            // 7. CHECK VISITED.
            if(vis[node]==0) {

                // 8. NEW SCC → Increment count.
                count++;

                // 9. DFS ON REVERSED GRAPH.
                helperDFS(node,vis,adjT);
            }
        }

        // 10. RETURN SCC COUNT.
        return count;
    }
}
