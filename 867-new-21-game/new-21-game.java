class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // Edge case: if k == 0, Alice stops immediately (always <= n)
        // Or if n >= k + maxPts, Alice can never exceed n
        if (k == 0 || n >= k - 1 + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0, result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) { // still drawing cards
                windowSum += dp[i];
            } else { // stopped, count towards result
                result += dp[i];
            }

            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }
        return result;
    }
}
