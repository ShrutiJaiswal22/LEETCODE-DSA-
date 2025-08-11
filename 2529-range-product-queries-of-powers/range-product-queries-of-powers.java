class Solution {
    static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Build the powers array from n
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                list.add(1 << i);
            }
        }
        int m = list.size();

        // Step 2: Build prefix product array
        long[] prefix = new long[m];
        prefix[0] = list.get(0);
        for (int i = 1; i < m; i++) {
            prefix[i] = (prefix[i - 1] * list.get(i)) % MOD;
        }

        // Step 3: Answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = (int) prefix[r];
            } else {
                long num = prefix[r];
                long den = prefix[l - 1];
                ans[i] = (int) ((num * modPow(den, MOD - 2, MOD)) % MOD);
            }
        }

        return ans;
    }

    // Modular exponentiation
    private long modPow(long base, long exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
