public class OddOrEven {
    public static void isOddOrEven(int n) {
        if ((n & 1) > 0) {
            System.out.println("the number is odd");
            return;
        } else {
            System.out.println("The number is even ");
            return;
        }


    }

    public static void main(String[] args) {
isOddOrEven(143);
    }
}
