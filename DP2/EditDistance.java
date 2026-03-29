public class EditDistance {
    public static int editDistance(String str1, String str2) { // convert str1 to str2
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        // initialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j; /*
                                   * if str1.length =0 for convert str1 to str2 str2.length operation is required
                                   */

                } else if (j == 0) {
                    dp[i][j] = i; /*
                                   * if str2.length =0 for convert str1 to str2 str1.length operation is required
                                   */
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // not equal
                    // // add // replace // delete
                    int add = dp[i][j - 1] + 1; // add one operation +1
                    int delete = dp[i - 1][j] + 1; // delete one operatioj +1
                    int replace = dp[i - 1][j - 1]; // reaplace one item +1

                    dp[i][j] = Math.min(add, Math.min(replace, delete));

                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ab";
        System.out.println(editDistance(str2, str1));

    }
}
