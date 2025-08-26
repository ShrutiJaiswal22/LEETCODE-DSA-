class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSq = 0; // store squared diagonal
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int l = rect[0];
            int w = rect[1];
            int diagonalSq = l * l + w * w;
            int area = l * w;

            // condition 1: longer diagonal
            // condition 2: same diagonal but bigger area
            if (diagonalSq > maxDiagonalSq || 
               (diagonalSq == maxDiagonalSq && area > maxArea)) {
                maxDiagonalSq = diagonalSq;
                maxArea = area;
            }
        }

        return maxArea;
    }
}
