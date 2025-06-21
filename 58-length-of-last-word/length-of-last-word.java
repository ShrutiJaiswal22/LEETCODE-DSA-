
class Solution {
    public int lengthOfLastWord(String s) {
        // Trim trailing spaces
        s = s.trim();

        // Find the last index of space
        int lastSpaceIndex = s.lastIndexOf(' ');

        // Return length of substring after the last space
        return s.length() - lastSpaceIndex - 1;
    }

    // Example usage
    // public static void main(String[] args) {
    //     LengthOfLastWord sol = new LengthOfLastWord();
    //     System.out.println(sol.lengthOfLastWord("Hello World"));              // Output: 5
    //     System.out.println(sol.lengthOfLastWord("   fly me   to   the moon  ")); // Output: 4
    //     System.out.println(sol.lengthOfLastWord("luffy is still joyboy"));   // Output: 6
    // }
}
