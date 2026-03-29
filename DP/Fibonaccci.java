public class Fibonaccci {

    public static int fibonacciREcursion(int n) { // 2^n
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacciREcursion(n - 1) + fibonacciREcursion(n - 2);
    }

    public static int fibUsingDp(int n, int fib[]) { // linear
        if (n == 0 || n == 1) {
            return n;
        }
        if (fib[n] != 0) { // fibonacci of n is already calculatecd
            return fib[n];
        }

        return fib[n] = fibUsingDp(n - 1, fib) + fibUsingDp(n - 2, fib);
    }

    public static int fibTabulation(int n){
        int dp [] = new int [n+1];

        dp[0]=0;
        dp[1] =1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 6; 
        int fib[] = new int[n + 1];

        System.out.println(fibTabulation(n));
    }
}