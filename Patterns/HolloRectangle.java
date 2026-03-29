public class HolloRectangle {
    public static void HollowRectangle(int row, int columns) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == columns - 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void invertedAndRotatedHalfPyramid(int n) {
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print("   ");

            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void invertedPyramidWithNum(int n) {

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - i; j++) {
                System.out.print(" " + count++ + " ");
            }
            System.out.println();
        }
    }

    public static void floydsTraingle(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + count++ + " ");
            }
            System.out.println();
        }
    }

    public static void ZeroOne(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(" 0 ");
                } else {
                    System.out.print(" 1 ");
                }
            }
            System.out.println();
        }
    }

    public static void butterFly(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            for (int k = 1; k <= (2 * (n - i)); k++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            for (int k = 1; k <= (2 * (n - i)); k++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("   ");
            }
            // stars
            for (int j = 1; j <= n; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

    }

    public static void hollowRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int spaces = 1; spaces <= n - i; spaces++) {
                System.out.print("   ");
            }

            // stars
            for (int j = 1; j <= n; j++) {
                if (j == 1 || j == n || i == 1 || i == n) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }

            }

            System.out.println();
        }
    }

    // diamond Paatern
    public static void Diamond(int n) {
        for (int i = 1; i <= n; i++) {

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("   ");
            }
            // stars

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        for (int i = n; i >=1; i--) {

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("   ");
            }
            // stars

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        // second Half 

    }

    public static void main(String[] args) {
        // HollowRectangle(3, 5);
        // invertedAndRotatedHalfPyramid(5);
        // invertedPyramidWithNum(5);
        // invertedPyramidWithNum(5);
        // floydsTraingle(5);
        // ZeroOne(5);
        // butterFly(5);
        // solidRhombus(5);
        // hollowRhombus(5);
        Diamond(5);
    }
}