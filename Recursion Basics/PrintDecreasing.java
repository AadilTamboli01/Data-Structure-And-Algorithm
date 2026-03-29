public class PrintDecreasing {
    public static void printnToOne(int n) { // O(n)
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printnToOne(n-1);
    }

    public static void printOnetoN(int n){
     if(n==1){
        return;
     }
     printOnetoN(n-1);
     System.out.println(n);
    }
    public static void main(String[] args) {
printOnetoN(5);
    }
}