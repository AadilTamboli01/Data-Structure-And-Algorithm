public class CountingTrees {
    public static int countBSts(int n) {// O(n^2)
        int dp[] = new int[n + 1];

        dp[0] = 1; // 0 nodes 1 bst null

        dp[1] = 1; // 1 node 1 bst

        for (int i = 2; i <= n; i++) {
            // nodes = i ;
            for (int j = 0; j <= i - 1; j++) { // 0 to i-1 nodes = i nodes
                // j = left subtree nodes i-j-1 = right subtree nodes
                dp[i] += dp[j] * dp[i - j - 1]; // take all possible combination of nodes
            }
        }
        return dp[n];
    }

    public static void main(String[] args) { // catalan number approch
        System.out.println(countBSts(4));
    }
}
