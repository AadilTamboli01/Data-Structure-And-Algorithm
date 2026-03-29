public class QueueUsingLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {
        public static Node head;
        public static Node tail;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
        public static void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                // add first
                head = tail = newNode;
                return;
            }
            // add on rear means tail
            tail.next = newNode;
            tail = newNode;
            return;

        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MIN_VALUE;

            }

            int data = head.data;
            head = head.next; // removed
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return Integer.MIN_VALUE;

            }
            return head.data;
        }

        public static void print() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return;

            }
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println();
            return;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.print();
    }

}
