import java.util.Stack;

public class QueueUsingTwoStacks {
    // step 1 add O(n)

    public static class Queue {
        public static Stack<Integer> s1 = new Stack<>(); // main stack
        public static Stack<Integer> s2 = new Stack<>(); // used for adding purpose

        // add O(n)
        public void add(int data) {
            // 3 steps
            // step 1 if s1 is empty then add in them
            if (s1.isEmpty()) {

                s1.push(data);
            } else {

                // step 1 if s1 is not empty then then push s1 data in s2 and add in s1
                while (!s1.isEmpty()) {
                    s2.push(s1.pop()); // s1 se nikal ke s2 me daldo
                }
                // push data in s1
                s1.push(data);
                // stemp 3 add all s2 data in s1

                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
            // adding is finish

        }

        public static boolean isEmpty() {
            if (s1.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue s Empty Cannot remove");
                return Integer.MIN_VALUE;
            }
            int data = s1.peek();
            s1.pop(); // remove top
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue s Empty Cannot remove");
                return Integer.MIN_VALUE;
            }
            return s1.peek();
        }

        public static void print() {
            if (isEmpty()) {
                System.out.println("Queue s Empty Cannot remove");
                return;
            }

            while (!s1.isEmpty()) {
                System.out.print(s1.pop() + " ");

            }
        }
    }

    // remove in O(n)

    public static class Queue2 {
        public static Stack<Integer> s1 = new Stack<>(); // main stack
        public static Stack<Integer> s2 = new Stack<>(); // used for adding purpose

        // add add in s1
        public static void add(int data) {
            s1.add(data);

        }

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // remove O(n)
        // 3 steps all element from s1 add s2
        // remove from s2 and then add all elmemtn in s1
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queueu is Empty cannot be remove");
                return Integer.MIN_VALUE;
            }
            // add s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // remove from s2
            int data = s2.peek();
            s2.pop();

            // add element in s1 from s2
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return data;
        }

        public static int peek() {
            // 3 steps all element from s1 add s2
            // get from s2 and then add all elmemtn in s1
            if (isEmpty()) {
                System.out.println("Queueu is Empty cannot be remove");
                return Integer.MIN_VALUE;
            }
            // add s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // remove from s2
            int data = s2.peek();
            // without removing

            // add element in s1 from s2
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return data;
        }
        public static void print() {
            if (isEmpty()) {
                System.out.println("Queue s Empty Cannot remove");
                return;
            }

            while (!s1.isEmpty()) {
                System.out.print(remove());

            }
        }

    }

    public static void main(String[] args) {
        Queue2 q = new Queue2();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        q.print();
    }
}
