import java.util.*;

public class ImplementStackUsingDeque {
    public static class Stack {
        static Deque<Integer> dq = new LinkedList<>();

        public static boolean isEmpty() {
            return dq.isEmpty();
        }

        public static void push(int data) { // jis end par add hora usi end se remove hoga
            dq.addFirst(data);
            return;

        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int data = dq.getFirst();
            dq.removeFirst();
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return dq.getFirst();
        }

        public static void print() {
            if (isEmpty()) {
                System.out.println("Not element availabke print ");
                return;
            }

            while(!dq.isEmpty()){
                System.out.print(pop());
            }
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        s.print();
    }
}
