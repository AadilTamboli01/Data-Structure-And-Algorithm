public class IsPowOfTwo {
    public static boolean isPowwo(int n){
        if((n&n-1)==0){
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isPowwo(2));
    }
}
