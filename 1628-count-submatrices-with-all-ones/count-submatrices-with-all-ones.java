class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];
        int total = 0;

        // Build heights array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[i][j] = (i == 0 ? 1 : heights[i-1][j] + 1);
                }
            }
        }

        // For each row, count rectangles ending there
        for (int i = 0; i < m; i++) {
            total += countRow(heights[i]);
        }

        return total;
    }

    // Count rectangles using histogram row
    private int countRow(int[] heights) {
        int n = heights.length;
        int count = 0;

        for (int j = 0; j < n; j++) {
            int minHeight = heights[j];
            for (int k = j; k >= 0 && minHeight > 0; k--) {
                minHeight = Math.min(minHeight, heights[k]);
                count += minHeight;
            }
        }
        return count;
    }
}
