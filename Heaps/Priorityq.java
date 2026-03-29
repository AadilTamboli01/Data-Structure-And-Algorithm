import java.util.*;

public class Priorityq {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(2);
        pq.add(1);
        pq.add(5);
        while (!pq.isEmpty()) {
   System.out.println(pq.remove());
        }
    }
}
