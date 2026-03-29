public class MountainRanges {
    public static int mountainRanges(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1; // using 0 pairs 1 mountain can form
        dp[1] = 1; // using 1 pair 1 mountain can form

        for (int i = 2; i <= n; i++) {
            // i = no of mountain pairs
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];

    }

    public static void main(String[] args) { // with n pairs catalan of n moutain ranges can form
        System.out.println(mountainRanges(5));
    }
}
