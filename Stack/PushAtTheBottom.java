import java.util.Stack;

public class PushAtTheBottom {
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

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

       
        System.out.println("after push at bottom");
        pushAtBOttom(100, s);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
     
    }
}
