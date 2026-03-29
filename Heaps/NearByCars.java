import java.util.PriorityQueue;

public class NearByCars {
    static class Cars implements Comparable<Cars> {
        int indx;
        int distanceSq;

        public Cars(int indx, int distanceSq) {
            this.indx = indx;
            this.distanceSq = distanceSq;
        }

        @Override
        public int compareTo(Cars c2) { // sort on the basis of the dissq
            return this.distanceSq - c2.distanceSq;
        }
    }

    public static void main(String[] args) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<Cars> pq = new PriorityQueue<>();
        // add cars in pq
        for (int i = 0; i < points.length; i++) {
            int distanceSq = ((points[i][0] * points[i][0]) + (points[i][1] * points[i][1])); // x^2 +y2
            pq.add(new Cars(i, distanceSq));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().indx);
        }
    }
}
