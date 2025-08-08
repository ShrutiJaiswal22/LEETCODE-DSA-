class Solution {
    public double soupServings(int n) {
        if (n > 4800) return 1.0; // threshold optimization
        int N = (n + 24) / 25; // scale down
        Double[][] memo = new Double[N + 1][N + 1];
        return dfs(N, N, memo);
    }

    private double dfs(int a, int b, Double[][] memo) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (memo[a][b] != null) return memo[a][b];

        double res = 0.25 * (
            dfs(a - 4, b, memo) +
            dfs(a - 3, b - 1, memo) +
            dfs(a - 2, b - 2, memo) +
            dfs(a - 1, b - 3, memo)
        );

        memo[a][b] = res;
        return res;
    }
}
