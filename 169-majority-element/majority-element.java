class Solution {
    public int majorityElement(int[] nums) {
    
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // choose a new candidate
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
 

    }
}