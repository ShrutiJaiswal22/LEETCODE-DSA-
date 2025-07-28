
public class Solution {
    private int maxOr = 0;
    private int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        backtrack(nums, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr > maxOr) {
                maxOr = currentOr;
                count = 1;
            } else if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        // Include nums[index]
        backtrack(nums, index + 1, currentOr | nums[index]);

        // Exclude nums[index]
        backtrack(nums, index + 1, currentOr);
    }
}
