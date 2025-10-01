class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = numBottles;
        int empty = numBottles;
        
        while (empty >= numExchange) {
            int newBottles = empty / numExchange;  // how many full bottles we get
            totalDrank += newBottles;              // drink them
            empty = empty % numExchange + newBottles; // remaining empty + new empty
        }
        
        return totalDrank;
    }
}
