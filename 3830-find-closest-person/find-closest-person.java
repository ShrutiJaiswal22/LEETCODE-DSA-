class Solution {
    public int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(x - z);  // distance of Person 1 from Person 3
        int dist2 = Math.abs(y - z);  // distance of Person 2 from Person 3
        
        if (dist1 < dist2) {
            return 1;
        } else if (dist2 < dist1) {
            return 2;
        } else {
            return 0;
        }
    }
}
