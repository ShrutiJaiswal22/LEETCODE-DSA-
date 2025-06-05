class Solution {
    public boolean isPowerOfTwo(int n) {
        // Only positive numbers and only one bit set
        return n > 0 && (n & (n - 1)) == 0;
    }
}
