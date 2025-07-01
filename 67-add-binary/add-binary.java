import java.math.BigInteger;

public class Solution {
    public static String addBinary(String a, String b) {
        // Parse as binary using BigInteger
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);

        // Bitwise addition using XOR and AND with carry
        while (!y.equals(BigInteger.ZERO)) {
            BigInteger carry = x.and(y);
            x = x.xor(y);
            y = carry.shiftLeft(1);
        }

        // Return binary string result
        return x.toString(2);
    }

    // public static void main(String[] args) {
    //     // Test with large binary strings
    //     String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
    //     String b = "110101001011101110001111100011011101011110000100001011011000000110001101000000110110110001101";

    //     System.out.println(addBinary(a, b));
    // }
}

// import java.math.BigInteger;
// class Solution {
//     public String addBinary(String a, String b) {
//       int aLen = a.length();
//         int bLen = b.length();
//         if (aLen < bLen) {
//             return addBinary(b, a);
//         }

//         int i = aLen-1;
//         int j = bLen-1;
//         char[] result = new char[aLen + 1];
//         int k = a.length();
//         int carry = 0;
//         while (k>0 || carry == 1) {
//             int char1 = i >= 0 ? a.charAt(i--) - '0' : 0;
//             int char2 = j >= 0 ? b.charAt(j--) - '0' : 0;
//             int sum = carry + char1 + char2;
//             result[k--] = (char) ((sum & '1')+'0');
//             carry = sum >> 1;
//         }
//         return new String(result, k+1, result.length - k - 1);
//     }
// }

