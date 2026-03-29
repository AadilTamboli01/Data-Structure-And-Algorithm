public class GridWays {
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1; // one ways
        } else if (i == n || j == m) {
            return 0; // no ways
        }

        int way1 = gridWays(i, j + 1, n, m); // right
        int way2 = gridWays(i + 1, j, n, m); // down
        return way1 + way2;
    }

    public static void main(String[] args) {

        int n = 3,m=3;
      System.out.println(  gridWays(0, 0, n, m));
    }
}
