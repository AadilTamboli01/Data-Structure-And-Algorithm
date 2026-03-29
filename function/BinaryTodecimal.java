import java.util.*;

public class BinaryTodecimal {
    public static int binaryTodecimal(int n) {
        int dec = 0;
        int count = 0;
        while (n > 0) {
         
            int lastdigit = n % 10;
            dec += (lastdigit * Math.pow(2, count++));
            n /= 10;
        }
        return dec;
    }

    public static void main(String[] args) {
        System.out.println(binaryTodecimal(101));
    }
}