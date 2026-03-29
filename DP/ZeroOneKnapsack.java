public class ZeroOneKnapsack {

    // basic recursion
    public static int knapsack(int weight[], int value[], int w, int n) { // 2^n
        if (n == 0 || w == 0) {
            return 0;
        }

        if (weight[n - 1] <= w) { // valid condition
            // n-1 = nth item on n-1 index beacause start form 0
            // include
            int ans1 = value[n - 1] + knapsack(weight, value, w - weight[n - 1], n - 1); // include our profit

            // exclude
            int ans2 = knapsack(weight, value, w, n - 1); // n is index ,, not include profit

            return Math.max(ans1, ans2);

        } else {
            // exclude condition
            return knapsack(weight, value, w, n - 1);
        }
    }

    // by using memoization
    public static int knapSackMemoization(int weight[], int value[], int w, int n, int dp[][]) { // N*W Time complexity

        // changine wariable is w and n we reqiuired 2 d matrix
        /*
         * no of row = n+1 no of elemetn +1
         * not of column = capacity +1
         * 
         * row 2 and col 1 means we have 1 size of knapsack and 2 element
         */

        // dp memory for storing answer
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != -1) { // alredy calculated profit
            return dp[n][w];

        }

        if (weight[n - 1] <= w) { // valid condition
            // n-1 = nth item on n-1 index beacause start form 0
            // include
            int ans1 = value[n - 1] + knapSackMemoization(weight, value, w - weight[n - 1], n - 1, dp); // include our
                                                                                                        // profit

            // exclude
            int ans2 = knapSackMemoization(weight, value, w, n - 1, dp); // n is index ,, not include profit

            return dp[n][w] = Math.max(ans1, ans2); // store the value and return

        } else {
            // exclude condition
            return dp[n][w] = knapSackMemoization(weight, value, w, n - 1, dp);
        }

    }

    // by using tabulation

    /*
     * create table assign meaning to each index and start filling
     * 
     */

    public static int knapSackTabulation(int weight[], int value[], int w) { // NW

        int dp[][] = new int[value.length + 1][w + 1]; // same as memoization

        // initialization w===0 return = n===0 return 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; // 0th column is zero

        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // fist row zero

        }

        // calculation
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // j = capacity
                int val = value[i - 1]; // value for ith itenm
                int wei = weight[i - 1]; // weight for ithe item

                if (wei <= j) { // our capacity is greater than weight
                    // valid case
                    // include
                    int includeProfit = val + dp[i - 1][j - wei]; // item inlcuded item -1 = i-1 included means capacity
                                                                  // - weioght of item j-wei

                    int exludeProfit = dp[i - 1][j]; // capacity as it is no ncluded

                    dp[i][j] = Math.max(includeProfit, exludeProfit);
                }else {
                    // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[value.length][w];

    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };

        int w = 7;
        // System.out.println(knapsack(weight, value, w, value.length));
        // n+1 , m+1 1 calomn extra for basecase initialization
        int dp[][] = new int[value.length + 1][w + 1]; // initialize with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // System.out.println(knapSackMemoization(weight, value, w, value.length, dp));
        System.out.println(knapSackTabulation(weight, value, w));

    }
}
