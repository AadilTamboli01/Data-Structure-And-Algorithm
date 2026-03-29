public class CoinChange {
    public static int coinchange(int coins[], int sum) { // total ways to change the coins
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];
        // initialization
        for (int i = 0; i < dp.length; i++) {// sum = 0 1 way
            dp[i][0] = 1;
        }
        for (int j = 1; j < dp[0].length; j++) {// coins = 0 0 way
            dp[0][j] = 0;
        }

        // O(n*sum)
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (coins[i - 1] <= j) { // valid = 2 chhoice include or exclude
                    // include
                    int include = dp[i][j - coins[i - 1]]; // change me se current coin - hojenga // repeatedly use coin
                    int exclude = dp[i - 1][j];

                    dp[i][j] = include + exclude; // count no of ways include + exclude
                } else { // invalid exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDP(dp);
  
        return dp[n][sum];

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
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(coinchange(coins, sum));
    }
}
