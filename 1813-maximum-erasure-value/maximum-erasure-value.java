class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        int maxScore = 0;
        int currentSum = 0;

        while (right < nums.length) {
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            seen.add(nums[right]);
            currentSum += nums[right];
            maxScore = Math.max(maxScore, currentSum);
            right++;
        }

        return maxScore;
    }
}
