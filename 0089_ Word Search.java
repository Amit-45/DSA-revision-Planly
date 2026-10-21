class Solution {
    private boolean backtrack(char[][] board,int i,int j,String word,int k) {
        // STOP: Have I matched every character? Word found.
        if(k==word.length())return true;

        // CHECK: Out of bounds or character mismatch? Stop this path.
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(k))return false;

        // MARK: Save the character and mark this cell as visited.
        char temp=board[i][j];
        board[i][j]='#';

        // EXPLORE: Try down, up, right, and left for the next character.
        boolean found=backtrack(board,i+1,j,word,k+1)||
                      backtrack(board,i-1,j,word,k+1)||
                      backtrack(board,i,j+1,word,k+1)||
                      backtrack(board,i,j-1,word,k+1);

        // RESTORE: Undo my choice so other paths can use this cell.
        board[i][j]=temp;

        return found;
    }

    public boolean exist(char[][] board,String word) {
        // START: Try every cell as the starting point.
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                // CHECK: Does this cell match the first character?
                if(board[i][j]==word.charAt(0)) {
                    // RECURSE: Search for the complete word from this cell.
                    if(backtrack(board,i,j,word,0))return true;
                }
            }
        }

        // FAIL: No path spells the word.
        return false;
    }
}
