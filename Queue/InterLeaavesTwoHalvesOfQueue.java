import java.util.*;

public class InterLeaavesTwoHalvesOfQueue {
    public static Queue<Integer> interLeaveTwoHalves(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();

        // add first half element in first half
        // q size is vary hence first calculate size
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        // inteleves
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
     

        q = interLeaveTwoHalves(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove());
        }
    }
}
