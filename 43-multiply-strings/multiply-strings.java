class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either is "0"
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];

        // Multiply each digit
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;        // current digit
                result[i + j] += sum / 10;           // carry to next position
            }
        }

        // Convert result to string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() == 0 && num == 0) continue; // skip leading zeros
            sb.append(num);
        }

        return sb.toString();
    }
}
