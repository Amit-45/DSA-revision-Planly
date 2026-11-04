import java.util.*;

class Solution {

    private void dfs(int node,List<List<Integer>> adj,int[] vis,Stack<Integer> st) {
        // MARK CURRENT NODE VISITED
        vis[node]=1;

        // CHECK ALL NEIGHBOURS
        for(int it:adj.get(node)) {
            // UNVISITED → DFS CALL
            if(vis[it]==0) {
                dfs(it,adj,vis,st);
            }
        }

        // ALL NEIGHBOURS PROCESSED → PUSH CURRENT NODE
        st.push(node);
    }

    public int[] topoSort(int V,List<List<Integer>> adj) {
        // CREATE ANSWER ARRAY + STACK + VISITED ARRAY
        int[] ans=new int[V];
        Stack<Integer> st=new Stack<>();
        int[] vis=new int[V];

        // TRAVERSE ALL NODES
        for(int i=0;i<V;i++) {
            // UNVISITED → DFS CALL
            if(vis[i]==0) {
                dfs(i,adj,vis,st);
            }
        }

        // POP STACK → FILL ANSWER ARRAY
        for(int i=0;i<V;i++) {
            ans[i]=st.pop();
        }

        // RETURN ANSWER
        return ans;
    }
}
