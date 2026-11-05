import java.util.*;

class Solution {
    public int countPaths(int n,List<List<Integer>> roads) {

        int mod=1000000007;

        // BUILD GRAPH
        List<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();

        for(List<Integer> road:roads) {
            int u=road.get(0),v=road.get(1),wt=road.get(2);
            adj[u].add(new int[]{v,wt});
            adj[v].add(new int[]{u,wt});
        }

        // INIT TIME = INFINITY, WAYS = 0
        long[] minTime=new long[n];
        Arrays.fill(minTime,Long.MAX_VALUE);
        int[] ways=new int[n];

        // SOURCE = (0,1) → MIN HEAP
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        minTime[0]=0;
        ways[0]=1;
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()) {

            // POLL MIN
            long[] curr=pq.poll();
            long time=curr[0];
            int node=(int)curr[1];

            if(time>minTime[node]) continue;

            // TRAVERSE NEIGHBOURS
            for(int[] it:adj[node]) {
                int adjNode=it[0],wt=it[1];

                // NEW TIME = TIME + WEIGHT
                long newTime=time+wt;

                // SHORTER → UPDATE TIME + REPLACE WAYS
                if(newTime<minTime[adjNode]) {
                    minTime[adjNode]=newTime;
                    ways[adjNode]=ways[node];
                    pq.add(new long[]{newTime,adjNode});
                }

                // EQUAL → ADD WAYS
                else if(newTime==minTime[adjNode]) {
                    ways[adjNode]=(ways[adjNode]+ways[node])%mod;
                }
            }
        }

        // RETURN WAYS[N-1]
        return ways[n-1];
    }
}
