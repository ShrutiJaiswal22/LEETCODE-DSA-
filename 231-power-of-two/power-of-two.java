class Solution {
    public boolean isPowerOfTwo(int n) {
        // n must be positive and have only one bit set
        return n > 0 && (n & (n - 1)) == 0;
    }
}
