class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];  // Since 1 <= arr[i] <= 500

        // Count frequencies
        for (int num : arr) {
            freq[num]++;
        }

        // Find the largest lucky number
        int result = -1;
        for (int i = 1; i <= 500; i++) {
            if (freq[i] == i) {
                result = i;  // update with current lucky number
            }
        }

        return result;
    }

    // For testing
    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     System.out.println(sol.findLucky(new int[]{2, 2, 3, 4}));       // Output: 2
    //     System.out.println(sol.findLucky(new int[]{1, 2, 2, 3, 3, 3})); // Output: 3
    //     System.out.println(sol.findLucky(new int[]{2, 2, 2, 3, 3}));    // Output: -1
    // }
}
