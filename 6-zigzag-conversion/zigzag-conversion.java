class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1 or s is shorter than numRows, no zigzag needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        
        // Initialize each row as an empty StringBuilder
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string and fill each row in zigzag manner
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Change direction when reaching top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    // Optional main method to test
    // public static void main(String[] args) {
    //     ZigzagConversion zc = new ZigzagConversion();

    //     System.out.println(zc.convert("PAYPALISHIRING", 3)); // Output: "PAHNAPLSIIGYIR"
    //     System.out.println(zc.convert("PAYPALISHIRING", 4)); // Output: "PINALSIGYAHRPI"
    //     System.out.println(zc.convert("A", 1));              // Output: "A"
    // }
}
