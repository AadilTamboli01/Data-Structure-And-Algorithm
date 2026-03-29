public class Sudokusolver {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {

        // check row wise (row is same column vary)
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) { // digit present
                return false;

            }
        }

        // check column wise column is same row vary
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // check grid wise
        int sr = (row / 3) * 3; // srtarting row of grid
        int sc = (col / 3) * 3; // starting col of grid

        // check in grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) { // soluion exist
            return true;
        }

        // recursion
        int nextrow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextCol = 0;
        }

        // if already no
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextrow, nextCol);
        }

        // place the saafe digit
        for (int digit = 1; digit <= 9; digit++) {

            if (isSafe(sudoku, row, col, digit)) { // if digit is safe then place
                sudoku[row][col] = digit; // place
                // call for next
                if (sudokuSolver(sudoku, nextrow, nextCol)) { // if solution
                    return true;
                }
                // if no solution unplplaced
                sudoku[row][col] = 0;

            }
        }
        return false;// solution not exist
    }

    public static void printsudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 }, { 4, 9, 0, 1,5, 7, 0, 0, 2 }, { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 }, { 0, 0, 0, 0, 2, 0, 0, 6, 0 }, { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 }, { 0, 4, 9, 0, 3, 0, 0, 5, 7 }, { 0, 2, 7, 0, 0, 9, 0, 1, 3 } };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("solution exist ");
            printsudoku(sudoku);
        } else {
            System.out.println("solution not exist ");
        }
    }

}
