class Solution {
    public int maximum69Number (int num) {
        // Convert number to string
        String s = String.valueOf(num);
        
        // Find the first '6' and replace it with '9'
        s = s.replaceFirst("6", "9");
        
        // Convert back to integer
        return Integer.parseInt(s);
    }
}
