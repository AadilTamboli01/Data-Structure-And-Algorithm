import java.util.Stack;

public class NextGreaterElement {

    public static int[] NextGreaterElement(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            int current = arr[i];
            while (!s.isEmpty() && current >= arr[s.peek()]) { // jab tak stack hav smallest element tab tak nikalte
                                                               // jaaao

                s.pop();

            }
            if (s.isEmpty()) {
                nextGreater[i] = -1; // no next greatger

            } else {
                nextGreater[i] = arr[s.peek()]; // jo bada hai top par hai stack ke
            }
            s.push(i); // push current in stack
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextGreater [] = NextGreaterElement(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}
