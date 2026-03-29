public class ClearInRange {
    public static int clearInRange(int n,int i,int j){

        int a = (~0<<j+1);
        int b= (int)Math.pow(2, i)-1; // aslo 1<<i -1
        int bitmask = a|b;

        return n&bitmask;

    }
    public static void main(String[] args) {
        System.out.println(clearInRange(10,2,7));
    }
}
