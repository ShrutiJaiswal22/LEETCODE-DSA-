class Solution {
    public int maximumDifference(int[] nums) {
        int minSoFar = nums[0];
        int maxDiff = -1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > minSoFar) {
                maxDiff = Math.max(maxDiff, nums[j] - minSoFar);
            } else {
                minSoFar = nums[j];
            }
        }

        return maxDiff;
    }

    // public static void main(String[] args) {
    //     MaxDifferenceFinder finder = new MaxDifferenceFinder();

    //     System.out.println(finder.maximumDifference(new int[]{7, 1, 5, 4}));   // Output: 4
    //     System.out.println(finder.maximumDifference(new int[]{9, 4, 3, 2}));   // Output: -1
    //     System.out.println(finder.maximumDifference(new int[]{1, 5, 2, 10}));  // Output: 9
    // }
}
