public class WildCardMatching {
    public static boolean isMatch(String text, String pattern) {//O(n*m)
        int n = text.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        // initialize
        dp[0][0] = true; // when pattern "" and text = "" mathced true
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false; // pattern 0 ""; no matching
        }
        // text is ""
        for (int j = 1; j < dp[0].length; j++) {
            if (pattern.charAt(j - 1) == '*') { // if last character is * then dp[i][j-1];
                dp[0][j] = dp[0][j - 1];
            }
            // otherwise false ? not mathc with empty text in java already false dont
            // explicit requirment
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    // if same or last character is ? match with last character of text

                    dp[i][j] = dp[i - 1][j - 1]; // humku chodke baaki ke match hore kya
                } else if (pattern.charAt(j - 1) == '*') { // pattern last character is * 2 cases ignore * or consider
                                                           // for match sequence of text
                    boolean ans1 = dp[i][j - 1]; // ignote *
                    boolean ans2 = dp[i - 1][j]; // math * with sequence of character
                    dp[i][j] = ans1 || ans2;
                } else {
                    dp[i][j] = false; // dont match or other problem occure in that case false 
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String text = "baaabab";
        String pattern = "*****ba*****ab";
        System.out.println(isMatch(text, pattern));
    }
}
