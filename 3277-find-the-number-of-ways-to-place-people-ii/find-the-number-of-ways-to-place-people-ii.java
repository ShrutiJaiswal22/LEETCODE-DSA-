import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // Check if all x are the same
        boolean allSameX = true;
        for (int i = 1; i < n; i++) {
            if (points[i][0] != points[0][0]) {
                allSameX = false;
                break;
            }
        }

        if (allSameX) {
            // Sort by y
            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
            return n - 1; // only adjacent pairs are valid
        }

        // General O(n^3) solution
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] A = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] B = points[j];

                // A must be upper-left of B
                if (A[0] <= B[0] && A[1] >= B[1]) {
                    boolean valid = true;

                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int[] C = points[k];
                        if (C[0] >= A[0] && C[0] <= B[0] &&
                            C[1] >= B[1] && C[1] <= A[1]) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }
}
