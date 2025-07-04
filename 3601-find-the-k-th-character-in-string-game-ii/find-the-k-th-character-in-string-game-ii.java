// class Solution {
//     public char kthCharacter(long k, int[] operations) {
        
//     }
// }

import java.util.*;

public class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1; // Initial string is "a"

        // Step 1: Calculate the lengths of the string after each operation
        for (int i = 0; i < n; i++) {
            lengths[i + 1] = Math.min(lengths[i] * 2, k);  // Avoid overflow
        }

        // Step 2: Recursive function to backtrack the kth character
        return getChar(k, operations, lengths, n, 0);
    }

    private char getChar(long k, int[] ops, long[] lens, int opIndex, int shift) {
        if (opIndex == 0) {
            // Base case: original string is "a"
            return (char) ((('a' - 'a' + shift) % 26) + 'a');
        }

        long half = lens[opIndex - 1];

        if (k <= half) {
            // First half: comes from previous unchanged
            return getChar(k, ops, lens, opIndex - 1, shift);
        } else {
            // Second half
            if (ops[opIndex - 1] == 0) {
                // Just a copy, same character
                return getChar(k - half, ops, lens, opIndex - 1, shift);
            } else {
                // Shifted copy
                return getChar(k - half, ops, lens, opIndex - 1, (shift + 1) % 26);
            }
        }
    }

    // For testing
    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     System.out.println(sol.kthCharacter(5, new int[]{0, 0, 0}));          // Output: a
    //     System.out.println(sol.kthCharacter(10, new int[]{0, 1, 0, 1}));      // Output: b
    //     System.out.println(sol.kthCharacter(100000000000000L, new int[100])); // Large test case
    // }
}
