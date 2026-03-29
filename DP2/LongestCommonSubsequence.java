public class LongestCommonSubsequence {
    public static int lcs(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs(str1, str2, n - 1, m - 1) + 1;

        } else {
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }

    }

    // by using memoization
    public static int lcsMemoization(String str1, String str2, int n, int m, int dp[][]) {

        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != 0) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcsMemoization(str1, str2, n - 1, m - 1, dp) + 1;

        } else {
            int ans1 = lcsMemoization(str1, str2, n - 1, m, dp);
            int ans2 = lcsMemoization(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }

    }

    public static int lcsTabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        // initialization when string 1 = 0 or string 2 = 0 no common subsequence
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str1.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    // different character
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);// n,m-1 n-1.m
                }
            }
        }
        printDP(dp);
        return dp[n][m];
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "ace";
        String str2 = "ac";
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
        dp[i][0] = 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
        dp[0][j] = 0;
        }

        System.out.println(lcsMemoization(str1, str2, str1.length(), str2.length(),
        dp));
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        // printDP(dp);
        // System.out.println(lcsTabulation(str1, str2));

    }
}
