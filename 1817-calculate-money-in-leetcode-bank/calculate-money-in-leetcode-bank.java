class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int total = 0;

        // Full weeks
        for (int i = 0; i < weeks; i++) {
            total += 28 + 7 * i; // 28 = 1+2+3+4+5+6+7
        }

        // Remaining days
        for (int i = 0; i < days; i++) {
            total += (weeks + 1) + i;
        }

        return total;
    }
}
