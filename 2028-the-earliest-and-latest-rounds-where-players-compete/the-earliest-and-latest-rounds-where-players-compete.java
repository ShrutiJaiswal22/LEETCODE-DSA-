// class Solution {
//     public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
//     }
// }

import java.util.*;

class Solution {
    Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return dfs(1, n, firstPlayer, secondPlayer);
    }

    private int[] dfs(int l, int r, int fp, int sp) {
        if (fp + sp == l + r) return new int[]{1, 1};
        String key = l + "," + r + "," + fp + "," + sp;
        if (memo.containsKey(key)) return memo.get(key);

        int len = r - l + 1;
        int mid = (len + 1) / 2;

        List<int[]> nextPairs = new ArrayList<>();

        // generate all possible player positions
        List<Integer> players = new ArrayList<>();
        for (int i = l; i <= r; i++) players.add(i);

        // collect all next possible sets based on match outcomes
        getNext(players, 0, players.size() - 1, new ArrayList<>(), nextPairs, fp, sp);

        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;

        for (int[] next : nextPairs) {
            Arrays.sort(next);
            int nf = -1, ns = -1;
            for (int i = 0; i < next.length; i++) {
                if (next[i] == fp) nf = i + 1;
                if (next[i] == sp) ns = i + 1;
            }
            int[] res = dfs(1, next.length, nf, ns);
            minRound = Math.min(minRound, res[0] + 1);
            maxRound = Math.max(maxRound, res[1] + 1);
        }

        int[] ans = new int[]{minRound, maxRound};
        memo.put(key, ans);
        return ans;
    }

    private void getNext(List<Integer> players, int i, int j, List<Integer> path, List<int[]> res, int fp, int sp) {
        if (i > j) {
            res.add(path.stream().mapToInt(k -> k).toArray());
            return;
        }

        if (i == j) {
            path.add(players.get(i));
            getNext(players, i + 1, j - 1, path, res, fp, sp);
            path.remove(path.size() - 1);
            return;
        }

        int a = players.get(i);
        int b = players.get(j);

        if ((a == fp && b == sp) || (a == sp && b == fp)) return;

        // one of them is fp or sp -> winner is that player
        if (a == fp || b == fp) {
            path.add(fp);
            getNext(players, i + 1, j - 1, path, res, fp, sp);
            path.remove(path.size() - 1);
        } else if (a == sp || b == sp) {
            path.add(sp);
            getNext(players, i + 1, j - 1, path, res, fp, sp);
            path.remove(path.size() - 1);
        } else {
            // both are ordinary -> try both possibilities
            path.add(a);
            getNext(players, i + 1, j - 1, path, res, fp, sp);
            path.remove(path.size() - 1);

            path.add(b);
            getNext(players, i + 1, j - 1, path, res, fp, sp);
            path.remove(path.size() - 1);
        }
    }
}
