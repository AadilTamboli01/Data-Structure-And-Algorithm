public class SumN {
    public static int sumOf1ToN(int n){
        if(n==0||n==1){
            return n;
        }
        return n+sumOf1ToN(n-1);
    }
    public static void main(String[] args) {
        System.out.println(sumOf1ToN(5));
    }
}
