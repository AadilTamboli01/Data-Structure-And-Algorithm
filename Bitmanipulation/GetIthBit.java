public class GetIthBit {
    public static void getIthBit(int n, int i) {
        int bitmask = (1 << i);

        if ((n & bitmask) == 0) {
            System.out.println(i + "th bit is 0");
        } else {
            System.out.println(i + "th bit is 1 ");
        }
    }

    public static void main(String[] args) {
getIthBit(5, 0);
    }
}
