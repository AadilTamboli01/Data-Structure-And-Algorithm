import java.util.*;

import javax.swing.text.StyleConstants;

public class StackUsingLinkedList {
    public static class Stack {
        static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
                return;
            }
            // add first
            newNode.next = head;
            head = newNode; // newNode is Head because head is top always push on the top
            return;

        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty ");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty ");
                return Integer.MIN_VALUE;
            }
            int data = head.data;
            // remove top means remove head
            head = head.next; // ehad is removed by java garbage colecotr
            return data;
        }

        public static void printStack() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");

            }
          while(!isEmpty()){
            System.out.print(pop()+" ");
          }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        s.printStack();
    }
}
