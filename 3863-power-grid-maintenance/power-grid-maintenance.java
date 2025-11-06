import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: Build DSU
        DSU dsu = new DSU(c + 1);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        // Step 2: Build components map -> TreeSet of online stations
        Map<Integer, TreeSet<Integer>> compMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            compMap.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] offline = new boolean[c + 1];
        List<Integer> result = new ArrayList<>();

        // Step 3: Process queries
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (!offline[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> onlineSet = compMap.get(root);
                    if (onlineSet.isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(onlineSet.first());
                    }
                }
            } else { // type == 2 → make offline
                if (!offline[x]) {
                    offline[x] = true;
                    compMap.get(root).remove(x);
                }
            }
        }

        // Step 4: Convert result to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}

// ----- DSU (Union-Find) -----
class DSU {
    int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[py] < rank[px]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
