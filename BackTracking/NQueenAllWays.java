public class NQueenAllWays {
    // N queens in n rows
    public static void nQueens(char chessBoard[][], int row) {
        // base case
        if (row == chessBoard.length) {
            printBoard(chessBoard);
            return;
        }
        // not check for safe condition
        for (int j = 0; j < chessBoard[0].length; j++) {
            chessBoard[row][j] = 'Q'; // place queen
            nQueens(chessBoard, row + 1); // fucntion call

            chessBoard[row][j] = 'X'; // remove the queen
        }
    }

    public static boolean isSafe(char chessBoard[][], int row, int col) {
        // vertically up
        for (int i = row - 1; i >= 0; i--) { // col same
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        // diagonally left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // diagolly right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard[0].length; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static int count = 0;

    // check for isSafe condition
    public static void nQueen2(char chessBoard[][], int row) {

        // base case
        if (row == chessBoard.length) {
            printBoard(chessBoard);
            count++;
            return;
        }
        // recursiion
        for (int j = 0; j < chessBoard[0].length; j++) {
            // place the queen if isSafe
            if (isSafe(chessBoard, row, j)) {
                chessBoard[row][j] = 'Q'; // place the queen
                nQueen2(chessBoard, row + 1); // recursion call
                chessBoard[row][j] = 'X';// remove the queen for the next iteration
            }

        }
    }

    public static void printBoard(char chessBoard[][]) {

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                System.out.print(chessBoard[i][j] + " ");

            }
            System.out.println();

        }
        System.out.println();
    }

    // print only one solution

    public static boolean nQueen3(char chessBoard[][], int row) {

        // base case
        if (row == chessBoard.length) {
            // printBoard(chessBoard);
            // count++;
            return true;
        }
        // recursiion
        for (int j = 0; j < chessBoard[0].length; j++) {
            // place the queen if isSafe
            if (isSafe(chessBoard, row, j)) {
                chessBoard[row][j] = 'Q'; // place the queen
                if (nQueen3(chessBoard, row + 1)) {
                    return true;
                } // recursion call
                chessBoard[row][j] = 'X';// remove the queen for the next iteration  backtracking 
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        char chessBoard[][] = new char[n][n];
        // initialization
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                chessBoard[i][j] = 'X';
            }
        }
        // nQueen2(chessBoard, 0);
        // System.out.println("No of ways = " + count);

        if (nQueen3(chessBoard, 0)) {
            System.out.println("solution exist ! ");
            printBoard(chessBoard);
        } else {
            System.out.println("Solution not exist ! ");
        }
    }
}