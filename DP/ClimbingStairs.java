public class ClimbingStairs {

    // by using recursion
    public static int climbingStaircaseREcursion(int n) { // 2^n
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        return climbingStaircaseREcursion(n - 1) + climbingStaircaseREcursion(n - 2);

    }

    // recursrtion memoization
    public static int climbingStairCaseMemoization(int n, int ways[]) { // O(n)
        if (n == 0) {
            return 1;

        } else if (n < 0) {
            return 0;
        }
        if (ways[n] != 0) { // already calculated
            return ways[n];

        }

        return ways[n] = climbingStairCaseMemoization(n - 1, ways) + climbingStairCaseMemoization(n - 2, ways);
    }

    // tabulation loop
    public static int clibingStairTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        // System.out.println("for stairs = 5 there is "+climbingStaircaseREcursion(5)+"
        // ways ");
        int n = 5;

        int dp[] = new int[n + 1];
        // System.out.println(climbingStairCaseMemoization(n, dp));

        System.out.println(clibingStairTabulation(n));
    }
}
