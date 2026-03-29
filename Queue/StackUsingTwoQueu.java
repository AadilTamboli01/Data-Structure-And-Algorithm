import java.util.*;

public class StackUsingTwoQueu {
    public static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return (q1.isEmpty() && q2.isEmpty()); // if both are empty
        }

        public static void push(int data) {
            // add in the queue who have already element
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            // O(n)
            // the queue having element remove from that ecept the last elment which is our
            // // top
            int top = -1;
            if (!q1.isEmpty()) { // element in q1
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break; // last element not add in the queue
                    }
                    q2.add(top);
                }

            } else {
                // element in q2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;// not add the last number
                    }
                    q1.add(top);
                }
            }

            return top; // top have the top value of teh stack

        }

        public static int peek() {
            // same logic as remove but witout removing the top

            int top = -1;
            if (!q1.isEmpty()) { // element in q1
                while (!q1.isEmpty()) {
                    top = q1.remove();

                    q2.add(top);
                }

            } else {
                // element in q2
                while (!q2.isEmpty()) {
                    top = q2.remove();

                    q1.add(top);
                }
            }

            return top; // top have the top value of teh stack
        }

        public static void print() {
            if (isEmpty()) {
                System.out.println("Empty Stack");
                return;
            }
            while (!isEmpty()) {
                System.out.print(pop());
            }
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        s.print();
    }
}
