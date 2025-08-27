class Solution {
    // directions: 0=↘, 1=↙, 2=↖, 3=↗
    private static final int[] DR = { 1, 1, -1, -1 };
    private static final int[] DC = { 1,-1, -1,  1 };

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][][] A  = new int[4][n][m]; // straight sequences ending at (r,c) starting with 1
        int[][][] T2 = new int[4][n][m]; // tails starting at (r,c) assuming current is 2 then 0,2,...
        int[][][] T0 = new int[4][n][m]; // tails starting at (r,c) assuming current is 0 then 2,0,...

        // 1) Build A for each direction: ensure predecessor (r-dr, c-dc) is processed first.
        for (int d = 0; d < 4; d++) {
            int dr = DR[d], dc = DC[d];
            int rStart = (dr == 1) ? 0 : n - 1;
            int rEnd   = (dr == 1) ? n : -1;
            int rStep  = (dr == 1) ? 1 : -1;

            for (int r = rStart; r != rEnd; r += rStep) {
                for (int c = 0; c < m; c++) {
                    int val = grid[r][c];
                    int best = (val == 1) ? 1 : 0;

                    int pr = r - dr, pc = c - dc;
                    if (in(pr, pc, n, m) && A[d][pr][pc] > 0) {
                        int expected = (A[d][pr][pc] % 2 == 1) ? 2 : 0; // after 1 comes 2, then 0, ...
                        if (val == expected) best = Math.max(best, A[d][pr][pc] + 1);
                    }
                    A[d][r][c] = best;
                }
            }
        }

        // 2) Build T2/T0 for each direction: ensure successor (r+dr, c+dc) is processed first.
        for (int d = 0; d < 4; d++) {
            int dr = DR[d], dc = DC[d];
            int rStart = (dr == 1) ? n - 1 : 0;
            int rEnd   = (dr == 1) ? -1    : n;
            int rStep  = (dr == 1) ? -1    : 1;

            for (int r = rStart; r != rEnd; r += rStep) {
                for (int c = 0; c < m; c++) {
                    // T2: current must be 2, then 0,2,...
                    if (grid[r][c] == 2) {
                        int t = 1;
                        int nr = r + dr, nc = c + dc;
                        if (in(nr, nc, n, m) && grid[nr][nc] == 0)
                            t = 1 + T0[d][nr][nc];
                        T2[d][r][c] = t;
                    } else {
                        T2[d][r][c] = 0;
                    }

                    // T0: current must be 0, then 2,0,...
                    if (grid[r][c] == 0) {
                        int t = 1;
                        int nr = r + dr, nc = c + dc;
                        if (in(nr, nc, n, m) && grid[nr][nc] == 2)
                            t = 1 + T2[d][nr][nc];
                        T0[d][r][c] = t;
                    } else {
                        T0[d][r][c] = 0;
                    }
                }
            }
        }

        // 3) Combine: straight (A) + optional single clockwise turn to d' = (d+1)%4 and its tail.
        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                for (int d = 0; d < 4; d++) {
                    int straight = A[d][r][c];
                    ans = Math.max(ans, straight); // no turn case

                    if (straight > 0) {
                        int nd = (d + 1) % 4; // clockwise 90°
                        int nr = r + DR[nd], nc = c + DC[nd];
                        if (in(nr, nc, n, m)) {
                            int expected = (straight % 2 == 1) ? 2 : 0;
                            int tail = (expected == 2) ? T2[nd][nr][nc] : T0[nd][nr][nc];
                            ans = Math.max(ans, straight + tail);
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean in(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
