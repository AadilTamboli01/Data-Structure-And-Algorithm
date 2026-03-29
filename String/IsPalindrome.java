public class IsPalindrome {
    public static boolean ispalindrome(String str) { // logn

        int si = 0, ei = str.length() - 1;
        while (si < ei) {
            if (str.charAt(si) != str.charAt(ei)) {
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }

    public static void main(String[] args) {

      System.out.println(ispalindrome("nitin"));
    }

}