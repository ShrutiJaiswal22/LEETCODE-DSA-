class Solution {
    public int countDigits(int num) {
        if (num == 0){
            return 0;
        }
        int count=0;
        int m;
        int num2 = num;
        while (num > 0) {
            m = num%10;
            if(num2 % m == 0){
                count++;
            } 
            num = num/10;
        }
        return count;
    }
}