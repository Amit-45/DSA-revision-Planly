import java.util.*;

class Solution {
    private boolean isSafe(int col,int node,int[] colors,List<List<Integer>> adj) {
        // CHECK: Does any connected neighbor already have this color?
        for(int neighbor:adj.get(node)) {
            if(colors[neighbor]==col)return false;
        }
        return true;
    }

    private boolean backtrack(int node,int m,int n,int[] colors,List<List<Integer>> adj) {
        // STOP: Have I colored every node? If yes, return true.
        if(node==n)return true;

        // TRY: Every available color from 1 to m.
        for(int col=1;col<=m;col++) {
            // CHECK: Is this color safe for the current node?
            if(isSafe(col,node,colors,adj)) {
                // TAKE: Assign this color to the current node.
                colors[node]=col;

                // RECURSE: Move to the next node and color it.
                if(backtrack(node+1,m,n,colors,adj))return true;

                // BACKTRACK: Undo my color and try another color.
                colors[node]=0;
            }
        }

        // FAIL: No available color works for this node.
        return false;
    }

    public boolean graphColoring(int[][] edges,int m,int n) {
        List<List<Integer>> adj=new ArrayList<>();

        // START: Create an empty neighbor list for every node.
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        // BUILD: Store the connections in both directions.
        for(int[] edge:edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // INITIALIZE: 0 means every node is uncolored.
        int[] colors=new int[n];

        // START: Begin coloring from node 0.
        return backtrack(0,m,n,colors,adj);
    }
}
