class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // Try all digits from 1 to 9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;  // Make tentative assignment
                            if (solve(board))       // Recursively continue
                                return true;
                            board[row][col] = '.';  // Backtrack
                        }
                    }
                    return false;  // No valid number found, trigger backtrack
                }
            }
        }
        return true;  // Solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row, column, and 3x3 box
        for (int i = 0; i < 9; i++) {
            // Row check
            if (board[row][i] == num) return false;
            // Column check
            if (board[i][col] == num) return false;
            // 3x3 box check
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}
