public class RodCutting {

    // unbounded knapsack varaition weight = length and val = price W = rodlength
    public static int rodCuttingTabulation(int length[], int price[], int n) { // n * rod length
        int dp[][] = new int[price.length + 1][n + 1];

        // no of ro = no of pecies of legtincliuded (0 to i) no column = length of rod j

        // initialization if no of pices and ro is = the profit price is 0

        // in ontest or test no intialize because by default 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; // rod length =0
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // peices is = 0
        }

        // calculation
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int len = length[i - 1]; // current pice length
                int cost = price[i - 1]; // curret rod price

                if (len <= j) { // inclide 2 choice include or exclude
                    // valid condtion
                    // dp[i][j] = max of include pices and exl=clude peice
                    dp[i][j] = Math.max(cost + dp[i][j - len], dp[i - 1][j]);// after including the rodlength =
                                                                             // rodelength - curre pece of rod

                } else {// exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[price.length][n];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };

        int lengthofRod = 8;
        System.out.println(rodCuttingTabulation(length, prices, lengthofRod));
    }
}
