class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        // For even numbers, fill pairs
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = -i;
            result[index++] = i;
        }

        // If n is odd, add 0
        if (n % 2 == 1) {
            result[index] = 0;
        }

        return result;
    }
}
