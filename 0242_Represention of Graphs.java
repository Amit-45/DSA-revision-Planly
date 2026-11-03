--------------ADJACENCY MATRIX (for UNDIRECTED graph)-----------------------------------------
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] adj = new int[n + 1][n + 1]; // matrix for 1-based 
        
        // Add the edges to the matrix
        for (int i = 0; i < m; i++) {
          
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            // Adding the bidirectional edges 
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
        sc.close();
    }
}

Note: For directed graphs, if there is an edge between u and v it means the edge only goes from u to v, i.e., v is the neighbor of u, but vice versa is not true.
--------------------------------------------ADJACENCY LIST-----------------------------------------------------------------------
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();

        // CREATE ADJACENCY LIST
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        // INITIALIZE EMPTY LISTS
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        // READ EDGES → ADD BOTH DIRECTIONS
        for(int i=0;i<m;i++) {
            int u=sc.nextInt(),v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        sc.close();
    }
}
