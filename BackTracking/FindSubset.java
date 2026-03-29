public class FindSubset {

    public static void findSubset(String str, String ans, int indx) {
        // base case
        if (indx == str.length()) {
            if (ans.length() == 0) {
                System.out.println("Null");
            } else {
                System.out.println(ans);
            }
            return;

        }

        // yes choice
        findSubset(str, ans + str.charAt(indx), indx + 1);

        // No choice
        findSubset(str, ans, indx + 1);
    }

    public static void main(String[] args) {
        String str = new String("abc");
        findSubset(str, "", 0);
        
    }
}
