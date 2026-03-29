public class StairCaseSeach {
    public static void stairCaseSearch(int mat[][], int key) {
        int row = mat.length - 1;
        int col = 0;
  // time complexity = log(n)
        while (row >= 0 && col < mat[0].length) { // n-1,0 approch also with 0,m-1  
            if (mat[row][col] == key) {
                System.out.println("Key found at " + "(" + row + " , " +col + ")");
                return;
            } else if (key < mat[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println("key not present in the matrix");
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
         stairCaseSearch(matrix, 29);
    }
}
