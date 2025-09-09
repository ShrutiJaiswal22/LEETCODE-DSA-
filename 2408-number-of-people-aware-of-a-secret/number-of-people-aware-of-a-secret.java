class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1; // Day 1: one person knows
        
        for (int i = 1; i <= n; i++) {
            // Each person who learns on day i will share from (i + delay) to (i + forget - 1)
            for (int j = i + delay; j < i + forget && j <= n; j++) {
                dp[j] = (dp[j] + dp[i]) % MOD;
            }
        }
        
        // Count people who still remember at the end of day n
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i > 0) ans = (ans + dp[i]) % MOD;
        }
        
        return (int) ans;
    }
}
