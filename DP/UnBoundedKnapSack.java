public class UnBoundedKnapSack {

    public static int unboundedKnapsackTabulation(int weight[], int value[], int w) { // N*W
        int dp[][] = new int[value.length + 1][w + 1]; // row = no of item colum = capacity

        // initialization if item ==0 or capacity = 0 profit = 0 ;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; // oth first column = 0
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // 0th row
        }

        // calcculate the profit
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int val = value[i - 1];
                int wei = weight[i - 1];

                // j is capacity of kanpsak
                if (wei <= j) { // valid

                    // maximum of include and exclude ith item can be include repeatedly
                    dp[i][j] = Math.max(val + dp[i][j - wei], dp[i - 1][j]); // maximum of include and exculde

                } else {
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
        return dp[value.length][w];
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };

        // int value[] = { 10, 20 };
        // int weight[] = { 1, 2};
        int w = 7 ;

        System.out.println(unboundedKnapsackTabulation(weight, value, w));

    }
}
