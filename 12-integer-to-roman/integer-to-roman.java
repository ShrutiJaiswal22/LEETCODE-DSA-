class Solution {
    public static String intToRoman(int num) {
        // Values and their corresponding Roman symbols
        int[] values =    {1000, 900, 500, 400, 100, 90,  50,  40,  10,  9,   5,   4,   1};
        String[] symbols ={"M",  "CM","D", "CD","C", "XC","L", "XL","X", "IX","V", "IV","I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            // Append symbol while num >= current value
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }

    // public static void main(String[] args) {
    //     System.out.println(intToRoman(3749));  // Output: MMMDCCXLIX
    //     System.out.println(intToRoman(58));    // Output: LVIII
    //     System.out.println(intToRoman(1994));  // Output: MCMXCIV
    // }
}
