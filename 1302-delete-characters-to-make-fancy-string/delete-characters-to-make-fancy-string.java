

class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // Count of current consecutive characters

        for (int i = 0; i < s.length(); i++) {
            // If it's the first character, always add
            if (i == 0) {
                result.append(s.charAt(i));
            } else {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                } else {
                    count = 1; // reset count if different character
                }

                if (count < 3) {
                    result.append(s.charAt(i));
                }
                // if count >= 3, skip the current character
            }
        }

        return result.toString();
    }
}
