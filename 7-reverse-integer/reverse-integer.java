// class Solution {
//     public int reverse(int x) {
//         int num=0 ,n = x  ; int mod;
            
//             while(x>0){
//                  mod = x%10;
//                  num = num*10 + mod ;
//                  x= x/10;
//             } 
//             while (x<0){
//                 mod = x%10;
//                  num = num*10 + mod ;
//                  x= x/10;
//             }


//             if((num > ((2^31) - 1)) && (num < (-2^31))){
//                 return 0;
//             }

//             return num ;
//     }
// }

public class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow before multiplying or adding
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && digit < -8)) return 0;
            
            rev = rev * 10 + digit;
        }
        
        return rev;
    }
}
