// class Solution {
//     public int numberOfSteps(int num) {
//         int steps = 0 ;
//         while(num>0){
//         if(num%2 == 0){
//             num = num/2;
//             } else {
//             num = num -1;
//             }
//             steps++;
//         }
//         return steps;
        
//     }
// }




 class Solution {
    // int count =0;
    // public int numberOfSteps(int num) {
    //     if(num ==0) {
    //         return 0;
    //     }

    //     if(num%2==0){
    //         num=num/2;
    //         count = count +1;
    //     }else{
    //         num = num-1;
    //         count = count +1;
    //     }
    //     numberOfSteps(num);

    //     return count;

        
    // }


    public int numberOfSteps(int num) {
        return helper( num, 0);
    }
    private static int helper(int n, int count){
        if(n==0){
            return count ;
        }
        if(n%2==0){
            return helper(n/2, count = count+1);
        }
        return helper(n-1, count = count+1);
    }
 }












