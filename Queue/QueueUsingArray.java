public class QueueUsingArray {
    public static class QueueBasic {
        static int arr[];
        static int size;
        static int rear;

        public QueueBasic(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) {
            // check for full
            if (rear == size - 1) {
                System.out.println(" Queue is full cannot be add ! ");
                return;
            }
            // add on the rear end
            rear++;
            arr[rear] = data;
        }

        public static int remove(int data) { // O(n) linear time complexity
            // cheke for queue is Emrpy
            if (isEmpty()) {
                System.out.println("queue is empty can't be remove ");
                return Integer.MIN_VALUE;
            }
            int front = arr[0]; // first element is Our front
            // ek ke element ku pich sarka do for deleting the first element
            for (int i = 0; i < rear; i++) { // 0 to rear only
                arr[i] = arr[i + 1];

            }
            // now rear also 1 back
            rear--;
            return front;
        }

        public static int peek() {
            // cheke for queue is Emrpy
            if (isEmpty()) {
                System.out.println("queue is empty can't be remove ");
                return Integer.MIN_VALUE;
            }
            return arr[0]; // front
        }
    }

    public static void main(String[] args) {
        QueueBasic q = new QueueBasic(5);
        q.add(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove(0);
        }
        System.out.println();
    }
}
