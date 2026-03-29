public class isPalindrome {
    public static boolean isPalindrome(int n) {
        int orig = n;
        int reverse = 0;
        while (n > 0) {
            int last = n % 10;
            reverse = reverse * 10 + last;
            n/=10;
        }
        if(reverse==orig){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
System.out.println(isPalindrome(121));
    }
}
