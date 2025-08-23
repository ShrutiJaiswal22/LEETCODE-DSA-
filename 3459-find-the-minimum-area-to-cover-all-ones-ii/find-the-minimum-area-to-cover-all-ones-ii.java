class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = Integer.MAX_VALUE;

        // 1) Three vertical stripes
        for (int c1 = 0; c1 < n - 2; c1++) {
            for (int c2 = c1 + 1; c2 < n - 1; c2++) {
                int a = rectArea(grid, 0, m - 1, 0, c1);
                int b = rectArea(grid, 0, m - 1, c1 + 1, c2);
                int c = rectArea(grid, 0, m - 1, c2 + 1, n - 1);
                if (a > 0 && b > 0 && c > 0) ans = Math.min(ans, a + b + c);
            }
        }

        // 2) Three horizontal stripes
        for (int r1 = 0; r1 < m - 2; r1++) {
            for (int r2 = r1 + 1; r2 < m - 1; r2++) {
                int a = rectArea(grid, 0, r1, 0, n - 1);
                int b = rectArea(grid, r1 + 1, r2, 0, n - 1);
                int c = rectArea(grid, r2 + 1, m - 1, 0, n - 1);
                if (a > 0 && b > 0 && c > 0) ans = Math.min(ans, a + b + c);
            }
        }

        // 3) One vertical cut + one horizontal cut → 4 L/T combinations
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                // TL + TR + bottom stripe
                ans = Math.min(ans, sumIfValid(
                        rectArea(grid, 0, r, 0, c),
                        rectArea(grid, 0, r, c + 1, n - 1),
                        rectArea(grid, r + 1, m - 1, 0, n - 1)));

                // BL + BR + top stripe
                ans = Math.min(ans, sumIfValid(
                        rectArea(grid, r + 1, m - 1, 0, c),
                        rectArea(grid, r + 1, m - 1, c + 1, n - 1),
                        rectArea(grid, 0, r, 0, n - 1)));

                // TR + BR + left stripe
                ans = Math.min(ans, sumIfValid(
                        rectArea(grid, 0, r, c + 1, n - 1),
                        rectArea(grid, r + 1, m - 1, c + 1, n - 1),
                        rectArea(grid, 0, m - 1, 0, c)));

                // TL + BL + right stripe  ← previously missing
                ans = Math.min(ans, sumIfValid(
                        rectArea(grid, 0, r, 0, c),
                        rectArea(grid, r + 1, m - 1, 0, c),
                        rectArea(grid, 0, m - 1, c + 1, n - 1)));
            }
        }

        return ans;
    }

    // Returns area of minimal bounding rectangle covering all 1's in subgrid.
    // If no 1's, returns 0.
    private int rectArea(int[][] g, int r1, int r2, int c1, int c2) {
        int minR = Integer.MAX_VALUE, maxR = -1, minC = Integer.MAX_VALUE, maxC = -1;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (g[i][j] == 1) {
                    if (i < minR) minR = i;
                    if (i > maxR) maxR = i;
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                }
            }
        }
        if (maxR == -1) return 0; // no 1s in this region
        return (maxR - minR + 1) * (maxC - minC + 1);
    }

    // Sum only if all three rectangles cover at least one '1'
    private int sumIfValid(int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) return Integer.MAX_VALUE;
        return a + b + c;
    }
}
