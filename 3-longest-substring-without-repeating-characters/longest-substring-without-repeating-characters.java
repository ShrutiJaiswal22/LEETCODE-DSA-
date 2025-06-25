class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character already seen, shrink the window from the left
            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Optional main method to test
    // public static void main(String[] args) {
    //     LongestSubstringWithoutRepeats solution = new LongestSubstringWithoutRepeats();

    //     System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
    //     System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
    //     System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
    //     System.out.println(solution.lengthOfLongestSubstring(""));         // Output: 0
    // }
}
