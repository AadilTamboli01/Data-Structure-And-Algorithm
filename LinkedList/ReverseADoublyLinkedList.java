public class ReverseADoublyLinkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    public static void printLl(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
        return;
    }

    public static void addFirst(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) { // no node
            head = tail = newNode;
            return;

        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static int removeFirst() {
        if (head == null) {
            System.out.println("cannot be removed because the ll is Empty ");
            return Integer.MIN_VALUE;
        }
        int data = head.data;
        if (size == 1) {
            head = tail = null;
            return data;
        }

        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    public static void addLast(int data) {

        if (head == null) { // khali linkedList means adding first node
            addFirst(data);
            return;

        }

        Node newNode = new Node(data);
        tail.next = newNode;// new node is next of tail
        newNode.prev = tail;
        tail = newNode; // now new Node is aur tail
        size++;

    }

    public static int removeLast() {
        if (head == null) {
            System.out.println("cannot remove ll is null ");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            return removeFirst();
        }
        int data = tail.data;
        tail = tail.prev;
        tail.next = null;
        return data;

    }

    public static void reverse() {
        Node curr = tail = head; // already assign tail = head afterr reverse head = tail
        Node prev = null;
        Node next;
        while (curr != null) {
            // revrese process
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            // updation
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        addFirst(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);

        printLl(head);
        reverse();
        printLl(head);
    }
}
