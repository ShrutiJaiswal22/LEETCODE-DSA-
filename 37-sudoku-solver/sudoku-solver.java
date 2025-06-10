// class Solution {
//     public void solveSudoku(char[][] board) {
//         solve(board);
//     }

//     private boolean solve(char[][] board) {
//         for (int row = 0; row < 9; row++) {
//             for (int col = 0; col < 9; col++) {
//                 if (board[row][col] == '.') {
//                     // Try all digits from 1 to 9
//                     for (char num = '1'; num <= '9'; num++) {
//                         if (isValid(board, row, col, num)) {
//                             board[row][col] = num;  // Make tentative assignment
//                             if (solve(board))       // Recursively continue
//                                 return true;
//                             board[row][col] = '.';  // Backtrack
//                         }
//                     }
//                     return false;  // No valid number found, trigger backtrack
//                 }
//             }
//         }
//         return true;  // Solved
//     }

//     private boolean isValid(char[][] board, int row, int col, char num) {
//         // Check row, column, and 3x3 box
//         for (int i = 0; i < 9; i++) {
//             // Row check
//             if (board[row][i] == num) return false;
//             // Column check
//             if (board[i][col] == num) return false;
//             // 3x3 box check
//             int boxRow = 3 * (row / 3) + i / 3;
//             int boxCol = 3 * (col / 3) + i % 3;
//             if (board[boxRow][boxCol] == num) return false;
//         }
//         return true;
//     }
// }


class Solution {
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // Initialize rows, cols, and boxes with existing digits
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex(i, j)][num] = true;
                }
            }
        }
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solve(board, row + 1, 0);
        if (board[row][col] != '.') return solve(board, row, col + 1);

        for (int num = 1; num <= 9; num++) {
            int boxIdx = boxIndex(row, col);
            if (!rows[row][num] && !cols[col][num] && !boxes[boxIdx][num]) {
                board[row][col] = (char) (num + '0');
                rows[row][num] = cols[col][num] = boxes[boxIdx][num] = true;

                if (solve(board, row, col + 1)) return true;

                board[row][col] = '.';
                rows[row][num] = cols[col][num] = boxes[boxIdx][num] = false;
            }
        }

        return false;
    }

    private int boxIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}

