// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
//     }
// }

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > target) continue; // Skip if num is too large

            current.add(num); // Choose the number
            backtrack(candidates, target - num, i, current, result); // Not i + 1 because we can reuse
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
