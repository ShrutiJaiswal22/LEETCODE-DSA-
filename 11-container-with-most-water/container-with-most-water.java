class Solution {
    public int maxArea(int[] height) {
        int left = 0;                // Start from the first bar
        int right = height.length - 1;  // Start from the last bar
        int maxArea = 0;

        while (left < right) {
            // Width between the two bars
            int width = right - left;

            // Height is the smaller of the two lines
            int minHeight = Math.min(height[left], height[right]);

            // Calculate area
            int currentArea = width * minHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // Example usage
    // public static void main(String[] args) {
    //     MaxWaterContainer sol = new MaxWaterContainer();
    //     int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    //     System.out.println(sol.maxArea(height1)); // Output: 49

    //     int[] height2 = {1, 1};
    //     System.out.println(sol.maxArea(height2)); // Output: 1
    // }
}
