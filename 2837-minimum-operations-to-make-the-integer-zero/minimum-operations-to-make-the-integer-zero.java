class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long target = (long) num1 - (long) k * num2;  // avoid overflow
            
            if (target < k) continue;  // must be >= k
            
            if (Long.bitCount(target) <= k) {
                return k;  // minimum k found
            }
        }
        return -1;
    }
}
