import java.util.PriorityQueue;

public class WeakestSoldiers {
    static class Soldiers implements Comparable<Soldiers> {
        int index;
        int soldiersCount;

        public Soldiers(int index, int soldiersCount) {
            this.soldiersCount = soldiersCount;
            this.index = index;
        }

        @Override
        public int compareTo(Soldiers s2) {
            if (this.soldiersCount == s2.soldiersCount) { // soldiers are same
                return this.index - s2.index; // sort on the basis of less index for weakst soldires

            } else {
                // sort on the basis of no of solers
                return this.soldiersCount - s2.soldiersCount;
            }
        }
    }

    public static void main(String[] args) {
        int Rows[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        int k = 2; // k weakest soldiers
        PriorityQueue<Soldiers> pq = new PriorityQueue<>();

        // add in pq
        for (int i = 0; i < Rows.length; i++) {
            int count = 0;
            for (int j = 0; j < Rows[0].length; j++) {
                count += Rows[i][j] == 0 ? 0 : 1; // count soldiers

            }
            pq.add(new Soldiers(i, count));
        }

        // print k soldiers
        for (int i = 0; i < k; i++) {
         System.out.print("Row"+(pq.remove().index+1)+" ");
        }
    }
}
