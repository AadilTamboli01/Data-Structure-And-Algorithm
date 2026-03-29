public class RodCutting {

    // value = > price W = rodlength weight => length

    public static int rodCutting(int length[], int prices[], int rodLength) {
        int n = prices.length;
        int dp[][] = new int[n + 1][rodLength + 1];

        // initialization if rodlentth is = profit = 0 if length = 0 profit = 0

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp.length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int currCutPrice = prices[i - 1];
                if (length[i - 1] <= j) { // j = current rod length
                    // valid 2 choices include exclude
                    int include = currCutPrice + dp[i][j - length[i - 1]]; // unbunded repeatation is allowed
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDP(dp);
        return dp[n][rodLength];
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

    public static void main(String[] args) { // variation of inbounded knapsack
        // int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int length[] = { 1, 2, 3, 4};
        int price[] = { 1, 5, 8, 9};
        System.out.println(rodCutting(length, price, 4));

    }
}
