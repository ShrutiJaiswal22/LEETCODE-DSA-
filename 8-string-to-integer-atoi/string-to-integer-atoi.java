class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

        // Step 1: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for sign
        if (i < n) {
            char c = s.charAt(i);
            if (c == '+') {
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            }
        }

        // Step 3: Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Handle overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return (int) (sign * result);
    }

    // Optional: main method to test the function
    // public static void main(String[] args) {
    //     StringToIntegerAtoi solution = new StringToIntegerAtoi();

    //     System.out.println(solution.myAtoi("42"));           // Output: 42
    //     System.out.println(solution.myAtoi("   -042"));      // Output: -42
    //     System.out.println(solution.myAtoi("1337c0d3"));     // Output: 1337
    //     System.out.println(solution.myAtoi("0-1"));          // Output: 0
    //     System.out.println(solution.myAtoi("words and 987"));// Output: 0
    //     System.out.println(solution.myAtoi("-91283472332")); // Output: -2147483648 (Integer.MIN_VALUE)
    // }
}
