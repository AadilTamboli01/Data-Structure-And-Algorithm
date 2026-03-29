public class StringConversion {
    // comvert string1 to string2 with insert and delete operation only
    /*
     * approch take lcs delete operation = deference between lcs and str1 and add
     * operation is differece str2 to lcs
     */

    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        // initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // not equal
                    int ans1 = dp[i][j - 1];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int stringConversion(String str1, String str2) {
        int lcs = lcs(str1, str2);
        // deleteOperation = defference between str1 and lcs
        int deleteOperation = Math.abs(lcs - str1.length());
        // add insertOperation = defference between lcs and str2
        int insertOperation = Math.abs(lcs - str2.length());
        
        return  deleteOperation+insertOperation;
    }

    public static void main(String[] args) {
        // String str1 = "pear";
        // String str2 = "sea";
        String str1 = "abcdef";
        String str2 = "aceg";
     
        System.out.println(stringConversion(str1, str2));

    }
}
