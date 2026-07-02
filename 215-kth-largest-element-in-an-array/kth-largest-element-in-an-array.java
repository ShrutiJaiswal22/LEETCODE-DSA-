import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            return -1;
        } 
        Arrays.sort(nums);
        int KthLargest = nums[nums.length - k];
        return KthLargest;
        
    }
}