class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != ch) return false;
            }
        }

        return stack.isEmpty();
    }

    // public static void main(String[] args) {
    //     ValidParentheses checker = new ValidParentheses();

    //     System.out.println(checker.isValid("()"));       // true
    //     System.out.println(checker.isValid("()[]{}"));   // true
    //     System.out.println(checker.isValid("(]"));       // false
    //     System.out.println(checker.isValid("([])"));     // true
    // }
}
