

class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int evenCount = 0;
        int oddCount = 0;

        // Count total evens and odds
        for (int num : nums) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }

        // Find longest alternating parity subsequence
        int maxAltLen = 1;
        int lastParity = nums[0] % 2;
        int altLen = 1;

        for (int i = 1; i < n; i++) {
            int parity = nums[i] % 2;
            if (parity != lastParity) {
                altLen++;
                lastParity = parity;
            }
        }

        return Math.max(Math.max(evenCount, oddCount), altLen);
    }
}
