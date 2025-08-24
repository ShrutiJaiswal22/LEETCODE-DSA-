class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeroCount = 0, maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // shrink window until at most 1 zero
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // update maxLen (delete one element → window size - 1)
            maxLen = Math.max(maxLen, right - left);
        }
        
        return maxLen;
    }
}
