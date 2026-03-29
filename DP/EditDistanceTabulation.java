public class EditDistanceTabulation {
    public static int editDistanceTabulation(String str1, String str2) { //N*m

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        // if str1.lengis empth th operation is str2.length if str2 is empty operation
        // is str1.length

        // intialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) { // str 1 =0 operation is j str2 length
                    dp[i][j] = j;

                }
                if (j == 0) {
                    // operation is str2 is empty operation is str1 length which is i

                    dp[i][j] = i;
                }
            }
        }

        // tabulation
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same no operation
                    dp[i][j] = dp[i - 1][j - 1]; // n-1 m-1 size decrease

                } else {
                    // dii=fference chars
                    int insert = dp[i][j - 1]; // str2 size --
                    int delete = dp[i - 1][j]; // str1 size --
                    int replace = dp[i - 1][j - 1]; // bot h string --

                    int min = Math.min(delete, Math.min(insert, replace)) + 1; // add aur operation +1
                    dp[i][j] = min;
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
String s1 = "abccc";
String s2 = "abd";
System.out.println(editDistanceTabulation(s1, s2));
    }
}
