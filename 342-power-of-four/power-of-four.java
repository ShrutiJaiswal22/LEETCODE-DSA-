class Solution {
    public boolean isPowerOfFour(int n) {
        // Condition 1: Must be positive
        if (n <= 0) return false;
        
        // Condition 2: Must be a power of two
        if ((n & (n - 1)) != 0) return false;
        
        // Condition 3: 1-bit must be in the correct position (odd index)
        return (n & 0x55555555) != 0;
    }
}
