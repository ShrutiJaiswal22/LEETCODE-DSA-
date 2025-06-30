class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first possible sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;          // Left pointer
            int right = nums.length - 1; // Right pointer

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If current sum is closer to the target than the previous closest, update it
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on comparison with target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // If the current sum equals the target, it's the best we can get
                    return currentSum;
                }
            }
        }

        return closestSum;
    }

    // Example usage
    // public static void main(String[] args) {
    //     ThreeSumClosest solution = new ThreeSumClosest();

    //     int[] nums1 = {-1, 2, 1, -4};
    //     int target1 = 1;
    //     System.out.println("Output: " + solution.threeSumClosest(nums1, target1)); // Output: 2

    //     int[] nums2 = {0, 0, 0};
    //     int target2 = 1;
    //     System.out.println("Output: " + solution.threeSumClosest(nums2, target2)); // Output: 0
    // }
}
