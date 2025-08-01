import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element is always 1

            for (int j = 1; j < i; j++) {
                int prev = result.get(i - 1).get(j - 1);
                int curr = result.get(i - 1).get(j);
                row.add(prev + curr);
            }

            if (i > 0) row.add(1); // Last element is 1 if i > 0
            result.add(row);
        }

        return result;
    }
}
