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
