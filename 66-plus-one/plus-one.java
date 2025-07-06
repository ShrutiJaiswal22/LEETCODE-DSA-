class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        // Traverse from end to start
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If all digits were 9, we need a new array
        int[] arr = new int[len + 1];
        arr[0] = 1;  // All other elements are 0 by default
        return arr;
    }
}
