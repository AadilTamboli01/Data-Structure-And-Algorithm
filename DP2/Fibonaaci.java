public class Fibonaaci {
    public static int fibnacci(int n) {

        return fibnacci(n - 1) + fibnacci(n - 2);
    }

    // dp
    public static int fib(int n, int fib[]) {
        if (n == 1 || n == 0) {
            return n;
        }

        if (fib[n] != 0) {
            return fib[n];
        }

        return fib[n] =fib(n - 1, fib) + fib(n - 2, fib);
    }

    public static void main(String[] args) {
        // System.out.println(fibnacci(10));
        int n = 5;
        int fib[] = new int[n + 1];
        System.out.println(fib(5,fib));

    }
}