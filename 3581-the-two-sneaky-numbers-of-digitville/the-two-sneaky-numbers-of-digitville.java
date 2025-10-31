import java.util.*;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        int idx = 0;
        
        for (int num : nums) {
            if (set.contains(num)) {
                result[idx++] = num;
                if (idx == 2) break; // stop once we found both
            } else {
                set.add(num);
            }
        }
        
        return result;
    }
}
