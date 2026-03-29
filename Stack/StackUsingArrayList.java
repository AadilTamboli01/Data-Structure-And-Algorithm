import java.util.ArrayList;

public class StackUsingArrayList {
    public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
            return;
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return Integer.MIN_VALUE;

            }

            int top = list.get(list.size()-1); // list.size()-1 is aur top
            list.remove(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return Integer.MIN_VALUE;

            }

            return list.get(list.size() - 1);
        }

        public static void printStack() {
            if (isEmpty()) {
                System.out.println("Cannot be print because the stack is Empty ! ");
                return;
            }
            while (!isEmpty()) {
                System.out.print(pop()+" -> ");
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

        s.printStack();
    }

}