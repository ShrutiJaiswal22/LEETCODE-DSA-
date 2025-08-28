import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diagMap = new HashMap<>();

        // Collect elements of each diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagMap.computeIfAbsent(key, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        // Sort diagonals based on rule
        for (int key : diagMap.keySet()) {
            List<Integer> list = diagMap.get(key);
            if (key >= 0) { 
                // bottom-left triangle (including main diagonal): descending
                list.sort(Collections.reverseOrder());
            } else {
                // top-right triangle: ascending
                Collections.sort(list);
            }
        }

        // Write back values in proper order
        Map<Integer, Integer> indexMap = new HashMap<>(); // to track positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                int pos = indexMap.getOrDefault(key, 0);
                grid[i][j] = diagMap.get(key).get(pos);
                indexMap.put(key, pos + 1);
            }
        }

        return grid;
    }
}
