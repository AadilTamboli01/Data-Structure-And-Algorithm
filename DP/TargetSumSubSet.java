public class TargetSumSubSet {

    public static boolean targetSubsetSumTabulation(int nums[], int target) { //NW
        boolean dp[][] = new boolean[nums.length + 1][target + 1];

        // initialization if the sum = 0 true means coumn = 0 and row = 0 false
        // for (int i = 0; i < dp.length; i++) {
        // dp[0][i] = false; // first row 0th item is // already false
        // }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true; // first column 0th sum is 0
        }

        // calculation
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int currSum = j; // capacity sum
                int value = nums[i - 1]; // 0 to ith item

                // include
                if (value <= j && dp[i - 1][j - value] == true) { // include has ans
                    dp[i][j] = true;

                } else if (dp[i - 1][j] == true) { // if iclude not has answer
                    dp[i][j] = true;

                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == true) {
                    System.out.print("true" + " ");
                } else {
                    System.out.print("false ");
                }
            }
            System.out.println();
        }

        return dp[nums.length][target];

    }

    public static void main(String[] args) {
        int nums[] = { 4, 2, 7, 1, 3 };
        // int nums[] = { 1, 2 };
        int sum = 10;

        System.out.println(targetSubsetSumTabulation(nums, sum));

    }
}
