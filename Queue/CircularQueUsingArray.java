public class CircularQueUsingArray {
    public static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        public Queue(int size) {
            arr = new int[size];
            this.size = size;
            this.front = -1;
            this.rear = -1;
        }

        public static boolean isEmpty() {
            return (rear == -1 && front == -1); // if both are -1 then empty

        }

        public static boolean isFull() {
            if ((rear + 1) % size == front) {
                return true;
            }
            return false;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("queue is full can't be add ");
                return;
            }
            if (front == -1) {
                front = 0; // picking element frist time
            }
            // add on the rear end
            // update rear
            rear = (rear + 1) % size;
            arr[rear] = data;
            return;

        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("the queue is Empty  cannot be remove ");
                return -1;
            }

            int data = arr[front];
            if (rear == front) {
                // onlu element in the queue
                rear = front = -1; // wmpty
            }
            // update front
            front = (front + 1) % size;
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("the queue is Empty  cannot be remove ");
                return -1;
            }

            return arr[front];
        }

        public static void print() {
            int temp = front;
            while (true) {
                System.out.print(arr[temp] + " ");

                if (temp == rear) {
                    break; // we travel all index of linkedlist

                }
                // update front means temp
                temp = (temp + 1) % size;

            }
            System.out.println();

        }

    }
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.print();
    }
}
