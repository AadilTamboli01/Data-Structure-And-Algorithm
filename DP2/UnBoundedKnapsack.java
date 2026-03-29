public class UnBoundedKnapsack {

     // trabulation
     public static int tabulationProfit(int value[], int weight[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <dp.length; i++) { // i - 0 to ith item
            for (int j = 1; j < dp[0].length; j++) { // j = capacity
                int v = value[i - 1]; // value of ith item
                int w = weight[i - 1]; // weight of ith item

                if (w <= j) {// current item weight is <= capacity
                    // valid condition
                    // include
                    int ans1 = v + dp[i][j - w]; // include the wight of ith item
                    int ans2 = dp[i - 1][j]; // not include ;

                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
       printDP(dp);
        return dp[n][W];

    }
    public static void printDP(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
      }
    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(tabulationProfit(value, weight, W, value.length));
    }
}
