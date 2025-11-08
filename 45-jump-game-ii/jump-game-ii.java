class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // track farthest point reachable from current index
            farthest = Math.max(farthest, i + nums[i]);
            
            // if we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;           // need one more jump
                currentEnd = farthest; // extend range to farthest
            }
        }

        return jumps;
    }
}
