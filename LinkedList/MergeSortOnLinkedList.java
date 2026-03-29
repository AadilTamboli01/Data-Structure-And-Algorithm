public class MergeSortOnLinkedList {
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
        }
        System.out.println();
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
        head = prev; // curr = null means head = prev;
    }

    public static void findAndReMoveFromLast(int n) {
        Node curr = head;
        int i = 1;
        // prev node = size -n
        while (i < (size - n)) {
            curr = curr.next;
            i++;
        }
        // now curr = prev node
        curr.next = curr.next.next; // removed the node nth from end
    }

    public static Node findMid(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) { // both even and odd case
            slow = slow.next;// +1
            fast = fast.next.next; // +2
        }
        return slow;
    }

    public static boolean isPalindrome() {
        if (head == null || head.next == null) {
            // empty and 1 NOde is always Palindrome
            return true;
        }
        Node midNode = findMid(head);

        // reverse the second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right part head
        Node left = head; // left head
        // checking palindrom
        while (right != null) { // jab ta right null nhi hojata tab tak
            if (right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;

        }
        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            // even and odd length of ll
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycleFromLinkedList() {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        // detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (isCycle == false) {
            return; // not a cyccle

        }
        // if cycle is Exist
        Node prev = null;
        slow = head; // initialize slow with head
        while (slow != fast) {
            prev = fast; // fast is point to last node of cycle
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null; // removecycle
        return;
    }

    public static Node getMergingMid(Node head) { // mid is lastnode of first half
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // mid
    }

    public static Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1); // dummy linkedLinkedList
        Node temp = mergeLL; // temp pointing to dummy linkedList
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;// pointing to smallest node
                head1 = head1.next;
                temp = temp.next;
            } else { // heead2 is smaller
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;

            }
        }

        // for remaining nodes
        while (head1 != null) {
            temp.next = head1;// pointing to smallest node
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // merge ll head node is dummy hence return the next node second node
        return mergeLL.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // mid
        Node mid = getMergingMid(head);
        // right head = mid.next
        Node rightHead = mid.next;
        // separate right and left part
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merging
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        MergeSortOnLinkedList ll = new MergeSortOnLinkedList();
        head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(" before sorting ");
        printLl(head);
        System.out.println("after sorting ");
        Node newHead  = mergeSort(head);
        printLl(newHead);
    }
}
