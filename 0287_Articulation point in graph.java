import java.util.*;

class Solution {
    int timer=1;

    void dfs(int node,int parent,boolean[] vis,int[] tin,int[] low,boolean[] mark,ArrayList<ArrayList<Integer>> adj) {

        // Mark visited
        vis[node]=true;

        // Set discovery and lowest time
        tin[node]=low[node]=timer;

        // Increment timer
        timer++;

        // Count DFS children
        int child=0;

        // Traverse neighbours
        for(int it:adj.get(node)) {

            // Skip parent
            if(it==parent) continue;

            // If neighbour is unvisited
            if(!vis[it]) {

                // DFS call
                dfs(it,node,vis,tin,low,mark,adj);

                // Update low using child's low
                low[node]=Math.min(low[node],low[it]);

                // Check non-root articulation point
                if(low[it]>=tin[node] && parent!=-1) {
                    mark[node]=true;
                }

                // Increment child count
                child++;
            }

            // If neighbour is already visited (back edge)
            else {
                low[node]=Math.min(low[node],tin[it]);
            }
        }

        // Special condition for DFS root
        if(child>1 && parent==-1) {
            mark[node]=true;
        }
    }

    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj) {

        // Initialize arrays
        boolean[] vis=new boolean[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        boolean[] mark=new boolean[n];

        // DFS for all connected components
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                dfs(i,-1,vis,tin,low,mark,adj);
            }
        }

        // Collect articulation points
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(mark[i]) {
                ans.add(i);
            }
        }

        // If no articulation point exists
        if(ans.size()==0) {
            return new ArrayList<>(Arrays.asList(-1));
        }

        return ans;
    }
}
