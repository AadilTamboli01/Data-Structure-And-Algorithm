import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ConnectNRopesWithMincost {
    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6 };
        // add in pq for sorting
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int rope1 = pq.remove();
            int rope2 = pq.remove();
            int currCost = rope1 + rope2; // new Rope
            cost += currCost; //
            // add new rope in ropes
            pq.add(currCost);

        }
        System.out.println("Cost for joining the ropes = "+cost);
    }
}
