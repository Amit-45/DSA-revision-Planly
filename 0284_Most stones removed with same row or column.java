
import java.util.*;

class DisjointSet {
    int[] rank,parent,size;

    DisjointSet(int n) {
        rank=new int[n+1];
        parent=new int[n+1];
        size=new int[n+1];

        for(int i=0;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    int findUPar(int node) {
        if(node==parent[node]) return node;
        return parent[node]=findUPar(parent[node]);
    }

    void unionBySize(int u,int v) {
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);

        if(ulp_u==ulp_v) return;

        if(size[ulp_u]<size[ulp_v]) {
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else {
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }
}

class Solution {

    public int maxRemove(int[][] stones,int n) {

        // 1. FIND MAX ROW & COLUMN
        int maxRow=0;
        int maxCol=0;

        for(int[] stone:stones) {
            maxRow=Math.max(maxRow,stone[0]);
            maxCol=Math.max(maxCol,stone[1]);
        }

        // 2. INITIALIZE DSU
        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);

        // 3. INITIALIZE HASHMAP
        Map<Integer,Integer> stoneNodes=new HashMap<>();

        // 4. TRAVERSE STONES
        for(int[] stone:stones) {

            // 5. GET ROW NODE
            int nodeRow=stone[0];

            // 6. CONVERT COLUMN NODE
            int nodeCol=stone[1]+maxRow+1;

            // 7. UNION ROW & COLUMN
            ds.unionBySize(nodeRow,nodeCol);

            // 8. STORE BOTH NODES
            stoneNodes.put(nodeRow,1);
            stoneNodes.put(nodeCol,1);
        }

        // 9. COUNT COMPONENTS
        int k=0;

        for(int key:stoneNodes.keySet()) {

            // 10. FIND ULTIMATE PARENT
            if(ds.findUPar(key)==key) {
                k++;
            }
        }

        // 11. CALCULATE ANSWER
        // 12. RETURN ANSWER
        return n-k;
    }

    public static void main(String[] args) {

        int n=6;
        int[][] stones={
            {0,0},{0,1},{1,0},
            {1,2},{2,1},{2,2}
        };

        Solution sol=new Solution();
        System.out.println(sol.maxRemove(stones,n));
    }
}
