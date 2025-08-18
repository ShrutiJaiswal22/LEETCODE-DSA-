class Solution {
    private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        // Convert to list of doubles for real division
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return backtrack(nums);
    }

    private boolean backtrack(List<Double> nums) {
        int n = nums.size();
        
        // Base case: only one number left
        if (n == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        // Try all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                List<Double> next = new ArrayList<>();
                // Add unused numbers
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next.add(nums.get(k));
                    }
                }

                // Try all 4 operations
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (backtrack(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    // Generate possible results from a and b
    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPSILON) res.add(a / b);
        if (Math.abs(a) > EPSILON) res.add(b / a);
        return res;
    }
}
