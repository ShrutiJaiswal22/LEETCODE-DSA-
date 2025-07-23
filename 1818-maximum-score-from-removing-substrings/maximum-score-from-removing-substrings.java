// class Solution {
//     public int maximumGain(String s, int x, int y) {
        
//     }
// }

class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return gainPoints(s, "ab", x, y);
        } else {
            return gainPoints(s, "ba", y, x);
        }
    }

    private int gainPoints(String s, String first, int firstGain, int secondGain) {
        StringBuilder sb = new StringBuilder();
        int score = 0;

        // First pass: remove all instances of the higher priority substring
        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == first.charAt(0) && c == first.charAt(1)) {
                sb.deleteCharAt(len - 1); // remove first.charAt(0)
                score += firstGain;
            } else {
                sb.append(c);
            }
        }

        // Second pass: remove all instances of the lower priority substring
        StringBuilder res = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            int len = res.length();
            if (len > 0 && res.charAt(len - 1) == first.charAt(1) && c == first.charAt(0)) {
                res.deleteCharAt(len - 1); // remove first.charAt(1)
                score += secondGain;
            } else {
                res.append(c);
            }
        }

        return score;
    }
}
