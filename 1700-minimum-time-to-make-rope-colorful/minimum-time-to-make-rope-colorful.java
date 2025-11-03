class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int n = colors.length();

        for (int i = 1; i < n; i++) {
            // If two consecutive balloons have same color
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Add the smaller time to total (remove the cheaper one)
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                // Keep the larger time as the new "previous" time (keep that balloon)
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalTime;
    }
}
