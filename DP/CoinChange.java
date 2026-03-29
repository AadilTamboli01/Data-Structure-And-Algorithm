public class CoinChange {

    public static int coinChangeTabulation(int coins[], int sum) { // n*W w is sum 

        int dp[][] = new int[coins.length + 1][sum + 1];

        // initialize // sum =0 way = 1 coin =0 way = 0

        // no of row = 0 ti ith cooin
        // no of column is jth sum

        // sum =0 coin =0 // 1 way

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1; // sum =0
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0; // coin =0
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int val = coins[i - 1]; // ith coin
                int weight = coins[i - 1];

                if (weight <= j) { // valid 2choices
                    // include
                    int include = dp[i][j - weight];
                    int exclude = dp[i - 1][j];

                    int totalWays = include + exclude;
                    dp[i][j] = totalWays;

                } else {
                    // invalid exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[coins.length][sum];
    }

    public static void main(String[] args) {
        int coins[] = {2,5,3,6};  
        int sum = 10;// ans 10
        // int coins[] ={1,2};
        // int sum=2;
        System.out.println(coinChangeTabulation(coins, sum));
    }
}
