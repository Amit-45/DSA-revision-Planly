class Solution {
    int timer=1;

    void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] tin,int[] low,List<List<Integer>> bridges) {
        // Mark visited
        vis[node]=1;

        // Set discovery and lowest time
        tin[node]=low[node]=timer;
        timer++;

        for(int it:adj.get(node)) {

            // Skip parent
            if(it==parent) continue;

            // If not visited
            if(vis[it]==0) {
                dfs(it,node,adj,vis,tin,low,bridges);

                // Update low using child's low
                low[node]=Math.min(low[node],low[it]);

                // Check bridge
                if(low[it]>tin[node]) {
                    bridges.add(Arrays.asList(node,it));
                }
            }

            // If already visited, check back edge
            else {
                low[node]=Math.min(low[node],tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n,List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        // Create adjacency list
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(List<Integer> edge:connections) {
            int u=edge.get(0);
            int v=edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis=new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];

        List<List<Integer>> bridges=new ArrayList<>();

        // Handle disconnected components
        for(int i=0;i<n;i++) {
            if(vis[i]==0) {
                dfs(i,-1,adj,vis,tin,low,bridges);
            }
        }

        return bridges;
    }
}
