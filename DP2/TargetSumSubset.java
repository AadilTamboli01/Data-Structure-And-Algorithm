public class TargetSumSubset {

  public static boolean isSubset(int nums[], int sum) {
    int n = nums.length;
    Boolean dp[][] = new Boolean[n + 1][sum + 1];

    // initlization sum = 0 true their is target sum no number is choose
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = true; // sum = 0 sum = column
    }

    for (int j = 1; j < dp[0].length; j++) {
      dp[0][j] = false;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {

        int v = nums[i - 1];
        if (nums[i - 1] <= j) { // valid number
          // include
          boolean include = dp[i - 1][j - v]; // include current num sum-v
          boolean exclude = dp[i - 1][j]; // not include num

          dp[i][j] = include || exclude;

        } else {
          // not valid
          dp[i][j] = dp[i - 1][j]; // exclude

        }
      }
    }
    printDP(dp);
    return dp[n][sum];
  }

  public static boolean memoization(int nums[], int sum, int n, Boolean dp[][]) {
    if (sum == 0) {
      return true;
    } else if (n == 0) {
      return false;
    }

    if (dp[n][sum] != null) {
      return dp[n][sum];
    }

    if (nums[n - 1] <= sum) {
      // valid
      boolean include = memoization(nums, sum - nums[n - 1], n - 1, dp);
      boolean exclude = memoization(nums, sum, n - 1, dp);

      dp[n][sum] = include;

    } else {
      // not valid
      boolean exclude = memoization(nums, sum, n - 1, dp);
      dp[n][sum] = exclude;
    }

    return dp[n][sum];

  }

  public static void printDP(Boolean dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int nums[] = { 4, 2, 7, 1, 3 };
    System.out.println(isSubset(nums, 10));
    int sum = 10;
    Boolean dp[][] = new Boolean[nums.length + 1][sum + 1];
    // initlization sum = 0 true their is target sum no number is choose
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = true; // sum = 0 sum = column
    }
    for (int j = 1; j < dp[0].length; j++) {
      dp[0][j] = false;
    }

    System.out.println(memoization(nums, sum, nums.length, dp));
    printDP(dp);
  }
}
