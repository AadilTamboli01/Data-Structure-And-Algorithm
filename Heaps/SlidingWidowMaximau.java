import java.util.PriorityQueue;

public class SlidingWidowMaximau {
    // assignment in queue byu using double ende queue
    static class Pair implements Comparable<Pair> {
        int val;
        int indx;

        public Pair(int val, int indx) {
            this.val = val;
            this.indx = indx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) { // O(nlogk)
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int res[] = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // first window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            // remove the non window eleement from pq
            while (!pq.isEmpty() && pq.peek().val <= (i - k)) { // i-k is out of the window element
                pq.remove();
            }
            // add in the resuklt
            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val; // curr result index 
        }

        // print the result
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
