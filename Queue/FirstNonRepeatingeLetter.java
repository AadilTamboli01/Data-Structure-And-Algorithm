import java.util.*;

public class FirstNonRepeatingeLetter {
    public static void firstNonReapeatingLetter(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            q.add(ch); // add in the que
            freq[ch - 'a']++; // frequency ++

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                // frequency is greater
                q.remove();
            }
            // 2 cases
            if (q.isEmpty()) {
                System.out.print("-1 ");

            } else {
                // first non repeating is peek
                System.out.print(q.peek() + " ");
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabccxb";
firstNonReapeatingLetter(str);
    }
}
