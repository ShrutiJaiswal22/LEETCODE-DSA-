class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start by assuming the prefix is the first string
        String prefix = strs[0];

        // Compare with all other strings
        for (int i = 1; i < strs.length; i++) {
            // Keep reducing the prefix until it matches the beginning of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}

//     // Sample usage
//     public static void main(String[] args) {
//         String[] input1 = {"flower", "flow", "flight"};
//         System.out.println("Longest Common Prefix: " + longestCommonPrefix(input1));  // Output: "fl"

//         String[] input2 = {"dog", "racecar", "car"};
//         System.out.println("Longest Common Prefix: " + longestCommonPrefix(input2));  // Output: ""
//     }
// }
