public class PrintXTothePowN {
    public static int pow(int x, int n) { // O(n)
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    public static int optimizedPow(int x, int n) {

        if(n==0){ // base case 
            return 1;
        }
        int halpPow = optimizedPow(x, n / 2);
        int halfPowSq = halpPow * halpPow;
        if (n % 2 != 0) {
            halfPowSq = x * halfPowSq;
        }
        return halfPowSq;

    }

    public static void main(String[] args) {
        System.out.println(optimizedPow(2, 3));
    }
}
