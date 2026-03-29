package function;
import java.util.ArrayList;


public class Binomial {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static int binCoeff(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        System.out.println(binCoeff(5, 2));
    }
}
