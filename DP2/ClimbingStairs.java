public class ClimbingStairs {
    public static int climbingStairs(int n, int fib[]) {// count ways 
        if (n == 0 || n == 1) {
            return 1;
        }
        if (fib[n] != 0) {
            return fib[n];
        }

        return fib[n] = climbingStairs(n - 1, fib) + climbingStairs(n - 2, fib);
    }

    public static int tabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int fib[] = new int[n + 1];
        System.out.println(climbingStairs(5, fib));
        System.out.println(tabulation(5));
    }
}
