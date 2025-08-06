class Solution {
    int[] seg;
    int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        seg = new int[4 * n];
        build(baskets, 0, n - 1, 1);

        int unplaced = 0;
        for (int fruit : fruits) {
            int idx = query(0, n - 1, 1, fruit);
            if (idx == -1) {
                unplaced++;
            } else {
                update(0, n - 1, 1, idx, 0); // mark basket as used
            }
        }
        return unplaced;
    }

    // Build segment tree
    private void build(int[] arr, int l, int r, int node) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, l, mid, node * 2);
        build(arr, mid + 1, r, node * 2 + 1);
        seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
    }

    // Query for leftmost index where capacity >= fruit
    private int query(int l, int r, int node, int fruit) {
        if (seg[node] < fruit) return -1; // no basket in this range can hold the fruit
        if (l == r) return l; // found basket
        int mid = (l + r) / 2;
        int leftAns = query(l, mid, node * 2, fruit);
        if (leftAns != -1) return leftAns;
        return query(mid + 1, r, node * 2 + 1, fruit);
    }

    // Update basket capacity
    private void update(int l, int r, int node, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(l, mid, node * 2, idx, val);
        else update(mid + 1, r, node * 2 + 1, idx, val);
        seg[node] = Math.max(seg[node * 2], seg[node * 2 + 1]);
    }
}
