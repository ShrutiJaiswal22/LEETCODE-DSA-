class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long totalSteps = prefix(r) - prefix(l - 1);
            ans += (totalSteps + 1) / 2;  // ceil division
        }
        return ans;
    }
    
    private long prefix(long n) {
        if (n <= 0) return 0;
        long res = 0;
        long start = 1;
        int steps = 1;
        while (start <= n) {
            long end = (long) Math.min(n, (long) Math.pow(4, steps) - 1);
            long count = end - start + 1;
            res += count * steps;
            steps++;
            start *= 4; // next range starts at 4^(steps-1)
        }
        return res;
    }
}
