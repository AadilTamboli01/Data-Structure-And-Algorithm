public class UpdateIthBit {
    public static int clearIthBit(int n, int i) {
        int bitmask = (1 << i);
        return n & ~bitmask;
    }

    public static int setIthBit(int n, int i) {

        int bitmask = (1 << i);
        return n | bitmask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // approch 1

        /*
         * if(newBit ==1){
         * return setIthBit(n, i);
         * }
         * else if(newBit==0){
         * return clearIthBit(n, i);
         * }
         */

         // approch two

         int updatedNum = clearIthBit(n, i);

         int bitmask = (newBit<<i);
         return updatedNum | bitmask;
    }

    public static void main(String[] args) {
System.out.println(updateIthBit(5, 1, 1));
    }
}
