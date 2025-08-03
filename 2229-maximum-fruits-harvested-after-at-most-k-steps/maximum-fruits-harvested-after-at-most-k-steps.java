// class Solution {
//     public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
//     }
// }


class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int left = 0, total = 0, maxFruits = 0;

        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            // Shrink window from left while total distance exceeds k
            while (left <= right && !canReach(fruits[left][0], fruits[right][0], startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    // Helper method to check if the current window can be walked within k steps
    private boolean canReach(int leftPos, int rightPos, int startPos, int k) {
        // Option 1: go to left first, then right
        int steps1 = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        // Option 2: go to right first, then left
        int steps2 = Math.abs(startPos - rightPos) + (rightPos - leftPos);
        return Math.min(steps1, steps2) <= k;
    }
}
