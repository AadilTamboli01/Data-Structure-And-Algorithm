import java.util.*;

public class LongestIncreasingSubSequence {

    public static int lcsTabulation(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n + 1][m + 1];

        // initialize n==0 || m==0 no lis returb 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;// arr[2].length=0 m=0
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // n=0
        }

        // calculation
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) { // same no add 1 of same character
                    dp[i][j] = dp[i - 1][j - 1] + 1; // reduce the sise i -1 j-1

                } else { // not same
                    // / 2 choisec n-1 m and m-1 n
                    int one = dp[i - 1][j];
                    int two = dp[i][j - 1];

                    int max = Math.max(one, two); // maximum length subsequence

                    dp[i][j] = max;

                }
            }
        }
        return dp[n][m];
    }

    public static int longestincreasingSubsequence(int arr[]) { // 
        // create copy and sort unique arr eleemtn
        HashSet<Integer> set = new HashSet<>();
        // add element
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // int arr[2] for sorted increasing subsequence
        int arr2[] = new int[set.size()];
        int i = 0;

        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        // sort arr2 accending order
        Arrays.sort(arr2);

        // calculat the lcs
       return  lcsTabulation(arr, arr2);

    }

    public static void main(String[] args) {
int arr1 [] = {50,3,10,7,40,80,200,500};
System.out.println(longestincreasingSubsequence(arr1));
    }
}
