
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // TRY: Find the first empty cell.
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') {

                    // TRY: Every digit from 1 to 9.
                    for(char digit='1';digit<='9';digit++) {

                        // CHECK: Is this digit safe in row, column and box?
                        if(areRulesMet(board,i,j,digit)) {

                            // TAKE: Place this valid digit.
                            board[i][j]=digit;

                            // RECURSE: Try solving the remaining Sudoku.
                            if(solve(board))return true;

                            // BACKTRACK: This choice failed. Empty the cell again.
                            board[i][j]='.';
                        }
                    }

                    // FAIL: No digit works for this empty cell.
                    return false;
                }
            }
        }

        // STOP: No empty cells remain. Sudoku is solved.
        return true;
    }

    private boolean areRulesMet(char[][] board,int row,int col,char digit) {
        // CHECK: Is this digit already in the same row or column?
        for(int i=0;i<9;i++) {
            if(board[row][i]==digit||board[i][col]==digit)return false;
        }

        // FIND: Starting position of this cell's 3x3 box.
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;

        // CHECK: Is this digit already in the same 3x3 box?
        for(int i=startRow;i<startRow+3;i++) {
            for(int j=startCol;j<startCol+3;j++) {
                if(board[i][j]==digit)return false;
            }
        }

        // SAFE: This digit follows all Sudoku rules.
        return true;
    }
}
