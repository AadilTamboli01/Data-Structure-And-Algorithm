public class ReverseALinkedList {
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
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }System.out.println();
        return;
    }

    public static void addInTheMiddle(int data, int index) {
        if (index < 0) {
            System.out.println("please enter the valid index ");
            return;
        }
        if (index == 0) {
            addFirst(data);
        }
        Node newNode = new Node(data);
        int i = 0;
        Node temp = head;
        while (i < (index - 1)) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return;
    }

    public static int iterativeSearch(int data, Node head) {
        if (head == null) {
            System.out.println("Linked List is Empty ");
            return -1;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == data) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public static int recursiveSearch(int data, Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == data) {
            return 0; // because head is index 0
        }
        int index = recursiveSearch(data, head.next); // search on the next position
        if (index == -1) {
            return -1;
        }
        return index + 1; // one plus for the next solution +

    }

    public static void reverseALinkedList() {

        Node curr = tail = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev; // reverse the link
            prev = curr;
            curr = next;
  
        }
        head = prev ; // curr = null means head = prev;
    }

    public static void main(String[] args) {
        ReverseALinkedList ll = new ReverseALinkedList();
        ll.head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        ll.printLl(head);
        ll.reverseALinkedList();
        System.out.println("After reverse ");
        ll.printLl(head);
    }
}
