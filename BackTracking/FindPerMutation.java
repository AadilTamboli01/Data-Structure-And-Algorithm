public class FindPerMutation {
    public static void findPermutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recuresion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // remove ith char from the string using substring method
            String newString = str.substring(0, i) + str.substring(i + 1, str.length()); // last index is non inclusive
            findPermutation(newString, ans + curr); // add currString in ans

        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, "");
    }
}
