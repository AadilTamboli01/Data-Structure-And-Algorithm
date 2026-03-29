public class friendsPairingProblem {
    public static int friendsPairingProblem(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int singleChoice = friendsPairingProblem(n - 1);
        int pairChoice = friendsPairingProblem(n - 2);

        return singleChoice + (n - 1) * pairChoice;
    }

    public static void main(String[] args) {
        System.out.println(friendsPairingProblem(4));
    }
}
