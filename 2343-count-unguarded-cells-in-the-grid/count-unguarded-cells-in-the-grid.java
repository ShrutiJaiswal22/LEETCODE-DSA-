import java.util.*;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Store guard and wall positions for O(1) lookup
        Set<String> guardSet = new HashSet<>();
        Set<String> wallSet = new HashSet<>();
        for (int[] g : guards) guardSet.add(g[0] + "," + g[1]);
        for (int[] w : walls) wallSet.add(w[0] + "," + w[1]);

        // Mark guarded cells
        boolean[][] guarded = new boolean[m][n];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // down, up, right, left

        for (int[] g : guards) {
            int r = g[0], c = g[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                while (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    String pos = nr + "," + nc;
                    if (guardSet.contains(pos) || wallSet.contains(pos)) break;
                    guarded[nr][nc] = true;
                    nr += d[0];
                    nc += d[1];
                }
            }
        }

        // Count unguarded and unoccupied cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String pos = i + "," + j;
                if (!guardSet.contains(pos) && !wallSet.contains(pos) && !guarded[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
