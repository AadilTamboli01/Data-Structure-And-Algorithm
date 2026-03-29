import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean isDuplicateParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                // if closing bracket
                int count = 0;
                while (stack.peek() != '(') {
                    stack.pop(); // remove element until eg a+b etc openign bracket is come
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate parenthesis

                } else {
                    stack.pop(); // remove the opening brackets
                }

            } else {
                // opening bracket and charcter a b c d + - etc
                stack.push(str.charAt(i));
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(a+b)";
        System.out.println("is Duplicate Parenthesis : "+isDuplicateParenthesis(str));
    }
}
