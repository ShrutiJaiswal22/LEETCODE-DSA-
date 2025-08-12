class Solution {
    static final int MOD = 1_000_000_007;
    Integer[][] dp;
    
    public int numberOfWays(int n, int x) {
        // Find maximum integer whose x-th power <= n
        int maxBase = 1;
        while (Math.pow(maxBase, x) <= n) {
            maxBase++;
        }
        maxBase--; // because loop goes one too far
        
        dp = new Integer[maxBase + 2][n + 1];
        return helper(1, n, x, maxBase);
    }
    
    private int helper(int curr, int remaining, int x, int maxBase) {
        if (remaining == 0) return 1; // Found a valid way
        if (curr > maxBase) return 0; // No more numbers to pick
        
        if (dp[curr][remaining] != null) return dp[curr][remaining];
        
        int res = 0;
        
        int power = (int) Math.pow(curr, x);
        
        // Option 1: take current number if possible
        if (power <= remaining) {
            res = (res + helper(curr + 1, remaining - power, x, maxBase)) % MOD;
        }
        
        // Option 2: skip current number
        res = (res + helper(curr + 1, remaining, x, maxBase)) % MOD;
        
        return dp[curr][remaining] = res;
    }
}
