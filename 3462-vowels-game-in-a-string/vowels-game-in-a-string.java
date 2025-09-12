class Solution {
    public boolean doesAliceWin(String s) {
        // Check if there is at least one vowel
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                return true; // Alice wins
            }
        }
        return false; // no vowels, Alice cannot move
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
