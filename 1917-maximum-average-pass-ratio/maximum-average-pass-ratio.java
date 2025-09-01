import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // push (gain, pass, total) for each class
        for (int[] c : classes) {
            int p = c[0], t = c[1];
            double gain = gain(p, t);
            pq.offer(new double[]{gain, p, t});
        }

        // assign extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int p = (int) top[1], t = (int) top[2];
            p++; t++;
            double gain = gain(p, t);
            pq.offer(new double[]{gain, p, t});
        }

        // compute final average
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            sum += cur[1] / cur[2];
        }

        return sum / classes.length;
    }

    // marginal gain function
    private double gain(int p, int t) {
        return ((double)(p + 1) / (t + 1)) - ((double)p / t);
    }
}
