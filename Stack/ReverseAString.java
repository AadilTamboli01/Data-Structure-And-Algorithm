import java.util.*;

public class ReverseAString {
    public static String ReverseAString(String str) {
        Stack<Character> s = new Stack<>();
        // add all s in stack
        int i = 0;
        while (i < str.length()) {
            s.push(str.charAt(i));
            i++;

        }
        // return the string
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
String name = "aadil";
 System.out.println(ReverseAString(name));
    }
}
