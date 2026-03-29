public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // create head and tell
    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public static void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            // linked list is empty
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;

    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { // if LinkedList is Empty
            head = tail = newNode;
            size++;

            return;
        }

        tail.next = newNode;
        size++;
        tail = newNode;
    }

    public static int removeFirst() {

        if (head == null) {
            System.out.println("Linked List is Empty ! ");
            return Integer.MIN_VALUE;
        }

        int data = head.data;
        if (size == 1) {
            head = tail = null;
            size--;
            return data;
        }
        head = head.next;
        size--;
        return data;

    }

    // removeLst
    public static int removeLast() {
        // O(n)
        if (head == null) {
            System.out.println("LinkedList is Empty ");
            return Integer.MIN_VALUE;
        }
        if (head == tail) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;

        }
        int data = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return data;
    }

    public static void printLl(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        return;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        head.next = new Node(10);

    }
}