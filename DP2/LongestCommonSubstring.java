public class LongestCommonSubstring {
    public static int lcSubstring(String str1, String str2) { // O(n*m)
        int n = str1.length();
        int m = str2.length();
        int ans = 0;

        int dp[][] = new int[n + 1][m + 1];
        // initialization if str1 ==0 str2 ==0 no common sunstrin only empty string of
        // length 0 hence lcs = 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same character length +1 of previous common length
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    // different character reset substring length
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return ans;

    }

    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "ab";
        System.out.println(lcSubstring(str1, str2));

    }
}
