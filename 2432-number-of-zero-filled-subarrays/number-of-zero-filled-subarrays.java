class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0, count = 0;
        
        for (int num : nums) {
            if (num == 0) {
                count++;
                result += count; // add all subarrays ending here
            } else {
                count = 0; // reset when non-zero
            }
        }
        
        return result;
    }
}
