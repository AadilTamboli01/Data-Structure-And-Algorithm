public class LongestCommonSubstring {

    // tabulation 
    public static int longestCSubstringTabulation(String s1 ,String s2){ //m*n
        int n = s1.length();
        int m = s2.length();
        int ans = 0 ;

        int dp[][] = new int[n + 1][m + 1];

        // intialozation if n=0 m=0 lcs is = 0  str1 ==0 or str2==0 lcsubstring = 0 
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; // m=0
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // n=0
        }

        // calculation 
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) { //i = ith character on i-1 index 
                    // same
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // 1+ reduce both length
                     ans = Math.max(ans,dp[i][j]);
                } else {
                    // not same 2 chice
                   dp[i][j] =0; // not substring counter resent 

                
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        String s = "ABC";
        String s1 = "ABC";
        System.out.println(longestCSubstringTabulation(s1, s));
    }
}
