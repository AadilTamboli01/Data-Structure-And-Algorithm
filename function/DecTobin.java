public class DecTobin {
    public static int decTobin(int n) {
        int pow = 0;
        int binary = 0;
        while (n > 0) {
            int rem = n % 2;
            binary += (rem * Math.pow(10, pow++));
            n /= 2;

        }
        return binary;
    }
    
    public static void main(String[] args) {
     System.out.println(decTobin(5));
    }
}
