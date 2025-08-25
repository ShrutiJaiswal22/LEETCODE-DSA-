class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, dir = 1;  // dir = 1 → up, dir = -1 → down
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            
            // moving upwards
            if (dir == 1) {
                if (col == n - 1) {   // hit right border
                    row++;
                    dir = -1;
                } else if (row == 0) {  // hit top border
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            } 
            // moving downwards
            else {
                if (row == m - 1) {   // hit bottom border
                    col++;
                    dir = 1;
                } else if (col == 0) {  // hit left border
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}
