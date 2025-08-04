// class Solution {
//     public int totalFruit(int[] fruits) {
        
//     }
// }

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int maxFruits = 0;
        int start = 0;

        for (int end = 0; end < fruits.length; end++) {
            int fruit = fruits[end];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            // If more than 2 types, shrink window from start
            while (basket.size() > 2) {
                int startFruit = fruits[start];
                basket.put(startFruit, basket.get(startFruit) - 1);
                if (basket.get(startFruit) == 0) {
                    basket.remove(startFruit);
                }
                start++;
            }

            maxFruits = Math.max(maxFruits, end - start + 1);
        }

        return maxFruits;
    }
}
