import java.util.*;

public class ReverseAStack {
    public static void pushAtBOttom(int data, Stack<Integer> s) {

        if (s.isEmpty()) { // base case
            s.push(data);
            return;
        }
        int top = s.pop(); // remove the data
        pushAtBOttom(data, s);
        // at the time of returnning push the data
        s.push(top);
    }

    public static void reverseAstack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;

        }
       
        int top = s.pop();
        reverseAstack(s);
        pushAtBOttom(top, s); // at the time of reversting 
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        reverseAstack(s);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
