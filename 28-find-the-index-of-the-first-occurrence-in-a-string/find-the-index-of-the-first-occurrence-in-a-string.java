class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // Edge case: if needle is longer than haystack, it can't be found
        if (nLen > hLen) return -1;

        // Loop through haystack
        for (int i = 0; i <= hLen - nLen; i++) {
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;  // Found the needle
            }
        }

        return -1;  // Not found
    }
}
