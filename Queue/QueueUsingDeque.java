import java.util.*;

public class QueueUsingDeque {
    public static class Queue {
        static Deque<Integer> dq = new LinkedList<>();

        public static boolean isEmpty() {
            return dq.isEmpty();
        }

        public static void add(int data) { // odd last rear
            dq.addLast(data);

        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;

            }
            // remove first front
            return dq.removeFirst();

        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;

            }
            return dq.getFirst();
        }

        public static void print() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return;

            }

            while (!dq.isEmpty()) {
                System.out.print(remove());
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        q.print();
    }
}
