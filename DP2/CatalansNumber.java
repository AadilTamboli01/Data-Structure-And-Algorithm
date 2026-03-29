public class CatalansNumber {
    public static int catalanRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i <= n - 1; i++) { // for calculating catalan of n only calculate the catalan of till n-1

            ans += catalanRec(i) * catalanRec(n - i - 1);
        }

        return ans;
    }

    public static int catalanMem(int n, int dp[]) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalanMem(i, dp) * catalanMem(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    // catalan tabulation
    public static int catalanTabulation(int n) { // O(n^2)
        int dp[] = new int[n + 1];
        // initalization cat of 0 and 1 is 1
        dp[0] = 1;
        dp[1] = 1;
        // int ans = 0;
        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // catalani = catalnj*ccatalani-j-1
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(catalanRec(19));
        System.out.println(catalanMem(19, new int[20]));
        System.out.println(catalanTabulation(3));
    }
}
