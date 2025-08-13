class Solution {
    public boolean isPowerOfThree(int n) {
        // Largest power of 3 that fits in int
        int maxPowerOfThree = 1162261467; // 3^19
        return n > 0 && maxPowerOfThree % n == 0;
    }
}
