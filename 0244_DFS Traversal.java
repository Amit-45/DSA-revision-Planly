import java.util.*;

// DFS function to prepare graph and start traversal
class Solution {
    public List<Integer> dfsOfGraph(int V,List<List<Integer>> edges) {
        boolean[] vis=new boolean[V];
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<V;i++)adj.add(new ArrayList<>());

        for(List<Integer> edge:edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        for(int i=0;i<V;i++) {
            if(!vis[i])dfs(i,adj,vis,ans);
        }
        return ans;
    }

    //-----------------------------RECURSIVE DFS--------------------------------
    // M → MARK | W → WORK | A* → CHECK NEIGHBOURS
    private void dfs(int node,List<List<Integer>> adj,boolean[] vis,List<Integer> ans) {
        vis[node]=true;
        ans.add(node);
        for(int it:adj.get(node)) {
            if(!vis[it])dfs(it,adj,vis,ans);
        }
    }
}

-----------------------------------------------------------------------------------------------------------
Iterative DFS using STack 
------------------------------------------------------------------------------------------------------------
import java.util.*;

// DFS function to prepare graph and start traversal
class Solution {
    public List<Integer> dfsOfGraph(int V,List<List<Integer>> edges) {
        boolean[] vis=new boolean[V];
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<V;i++)adj.add(new ArrayList<>());

        for(List<Integer> edge:edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                Stack<Integer> st=new Stack<>();
                st.push(i);
                vis[i]=true;

                while(!st.isEmpty()) {
                    int node=st.pop();
                    ans.add(node);

                    for(int it:adj.get(node)) {
                        if(!vis[it]) {
                            vis[it]=true;
                            st.push(it);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
