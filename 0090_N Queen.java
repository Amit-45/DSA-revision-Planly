
import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> board=new ArrayList<>();

        // START: Create an empty n x n board.
        for(int i=0;i<n;i++) {
            board.add(".".repeat(n));
        }

        // RECURSE: Start placing queens from row 0.
        backtrack(0,n,board,ans);
        return ans;
    }

    private void backtrack(int row,int n,List<String> board,List<List<String>> ans) {
        // STOP: Have I placed queens in all rows? Save this solution.
        if(row==n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        // TRY: Every possible column in the current row.
        for(int col=0;col<n;col++) {
            // CHECK: Is this position safe?
            if(isSafe(board,row,col,n)) {
                // TAKE: Place a queen at (row,col).
                char[] arr=board.get(row).toCharArray();
                arr[col]='Q';
                board.set(row,new String(arr));

                // RECURSE: Place a queen in the next row.
                backtrack(row+1,n,board,ans);

                // BACKTRACK: Remove my queen and try another column.
                arr[col]='.';
                board.set(row,new String(arr));
            }
        }
    }

    private boolean isSafe(List<String> board,int row,int col,int n) {
        int r=row,c=col;

        // CHECK: Is there a queen on my upper-left diagonal?
        while(r>=0&&c>=0) {
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
            c--;
        }

        r=row;
        c=col;

        // CHECK: Is there a queen directly above me?
        while(r>=0) {
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
        }

        r=row;
        c=col;

        // CHECK: Is there a queen on my upper-right diagonal?
        while(r>=0&&c<n) {
            if(board.get(r).charAt(c)=='Q')return false;
            r--;
            c++;
        }

        // SAFE: No queen can attack this position from above.
        return true;
    }
}
