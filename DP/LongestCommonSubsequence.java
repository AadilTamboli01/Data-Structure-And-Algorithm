public class LongestCommonSubsequence {

    // time complexity O(2^n)
    public static int lcsRecursion(String str1, String str2, int n, int m) { // n is length of str1 , m is length of
                                                                             // str2

        if (n == 0 || m == 0) { // base case
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            // carcters same

            return lcsRecursion(str1, str2, n - 1, m - 1) + 1; // +1 for commong character
        } else {
            int one = lcsRecursion(str1, str2, n - 1, m);
            int two = lcsRecursion(str1, str2, n, m - 1);

            return Math.max(one, two);
        }

    }

    // by using memoization
    public static int memoizationlcs(String str1, String str2, int n, int m, int dp[][]) {// m*n
        if (n == 0 || m == 0) {
            // base case
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            // same

            return dp[n][m] = memoizationlcs(str1, str2, n - 1, m - 1, dp) + 1;

        } else {
            // not same
            // diffenret two choices
            int one = memoizationlcs(str1, str2, n - 1, m, dp);
            int two = memoizationlcs(str1, str2, n, m - 1, dp);

            return dp[n][m] = Math.max(one, two); // store and return
        }
    }

    // tabulation
    public static int lcsTabulation(String str1, String str2) {// m*n
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        // intialozation if n=0 m=0 lcs is = 0  str1 ==0 or str2==0 lcs = 0 
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; // m=0
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // n=0
        }

        // calculation  tabulation bottom up 
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) { //i = ith character on i-1 index 
                    // same
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // 1+ reduce both length
                } else {
                    // not same 2 chice
                    int one = dp[i - 1][j];
                    int two = dp[i][j-1];

                    int max = Math.max(one, two);
                    dp[i][j] = max;
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        // String str1 = "abcde";
        // String str2 = "ace";
        String str1 = "ab";
        String str2 = "ac";
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        // initialize with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(memoizationlcs(str1, str2, str1.length(), str2.length(),
        // dp));
        System.out.println(lcsTabulation(str1, str2));
    }
}
