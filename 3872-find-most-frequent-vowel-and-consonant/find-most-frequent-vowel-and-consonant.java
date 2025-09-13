class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26]; // frequency for each letter
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String vowels = "aeiou";
        int maxVowel = 0, maxConsonant = 0;

        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if (vowels.indexOf(c) != -1) { 
                // vowel
                maxVowel = Math.max(maxVowel, freq[i]);
            } else { 
                // consonant
                maxConsonant = Math.max(maxConsonant, freq[i]);
            }
        }

        return maxVowel + maxConsonant;
    }
}
