import java.util.*;

public class SpiralMatrix {
    public static void spiralMatrix(int mat[][]) {
        int sr = 0;
        int er = mat.length - 1;
        int sc = 0;
        int ec = mat[0].length - 1;

        while (sr <= er && sc <= ec) {
            // top
            for (int j = sc; j <= ec; j++) {
                System.out.print(mat[sr][j] + " ");

            }
            // right
            for (int i = sr + 1; i <= er; i++) {
                System.out.print(mat[i][ec] + " ");
            }

            // btm
            for (int j = ec - 1; j >= sc; j--) {
                if (sr == er) {
                    break; // hum is e top me print karwa chuke hai
                }
                System.out.print(mat[er][j] + " ");
            }

            // left
            for (int i = er - 1; i >= sr + 1; i--) {
                System.out.print(mat[i][sc] + " ");
                if (sc == ec) {
                    break; // hum is right me print karwa chuke hai
                }
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
    }

    public static void main(String[] args) {
        int matrixOne[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int mat2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        spiralMatrix(matrixOne);
    }
}