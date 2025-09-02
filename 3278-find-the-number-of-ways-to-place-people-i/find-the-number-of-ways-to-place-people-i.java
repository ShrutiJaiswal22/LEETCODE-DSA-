class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] A = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] B = points[j];

                // Condition 1: A must be on upper-left of B
                if (A[0] <= B[0] && A[1] >= B[1]) {
                    boolean valid = true;

                    // Check all other points
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int[] C = points[k];

                        if (C[0] >= Math.min(A[0], B[0]) &&
                            C[0] <= Math.max(A[0], B[0]) &&
                            C[1] >= Math.min(A[1], B[1]) &&
                            C[1] <= Math.max(A[1], B[1])) {
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
