public class FloodFillAlgorithm {

    public static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int originalCol) {
        if (sr < 0 || sc < 0 || sc >= image[0].length || sr >= image.length || vis[sr][sc]
                || image[sr][sc] != originalCol) {
            return;
        }
        image[sr][sc] = color;
        // left
        helper(image, sr, sc - 1, color, vis, originalCol);
        // right
        helper(image, sr, sc + 1, color, vis, originalCol);
        // up
        helper(image, sr - 1, sc, color, vis, originalCol);
        // down
        helper(image, sr + 1, sc, color, vis, originalCol);

    }

    public static  int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]); // sr sc is original col
        return image;
    }

    public static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }; 
        int sr=1;int sc=1;
        int col=2;
        floodFill(image,sr,sc,col);
        printImage(image);
    }
}
