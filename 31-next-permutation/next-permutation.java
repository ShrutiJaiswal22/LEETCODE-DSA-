// class Solution {
//     public void nextPermutation(int[] nums) {
        
//     }
// }

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find first decreasing index from the end
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If found, find next larger element and swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix starting from i + 1
        reverse(nums, i + 1, n - 1);
    }

    // Helper method to swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a subarray
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
