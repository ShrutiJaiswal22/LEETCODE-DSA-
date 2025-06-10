
// // Java program for implementation
// // of Bubble Sort

// class bubble {  
//     void bubbleSort(int arr[])
//     {
//         int n = arr.length;
      
//         for (int i = 0; i < n - 1; i++)
//             for (int j = 0; j < n - i - 1; j++)
//                 if (arr[j] > arr[j + 1]) {
                  
//                     // swap temp and arr[i]
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                 }
//     }

//     // Driver method to test above
//     public static void main(String args[])
//     {
//         bubble ob = new bubble();
//         int a[] = { 64, 34, 25, 12 };
      
//         ob.bubbleSort(a);
      
//       	int n = a.length;
      
//         for (int i = 0; i < n; ++i)
//             System.out.print(a[i] + " ");
//         System.out.println();
//     }
// }

import java.util.Arrays;

public class bubble {
       public static void main(String[] args) {
       int[] arr ={1,2,3,4,5};
       bubblee(arr);
       System.out.println(Arrays.toString(arr));
       }
    
       static void bubblee(int[] arr ){
           boolean swapped;
           for (int i = 0; i < arr.length; i++) {
               swapped = false ;
               for(int j =1 ; j < arr.length-1; j++){
    //
    
                   if (arr[j-1] > arr[j] ){
                       int temp = arr[j];
                       arr[j] = arr[j-1];
                       arr[j-1] = temp;
                       swapped = true;
                   }
               }
               if(swapped==false)
                   break;
    
           }
    
    
       }
    }