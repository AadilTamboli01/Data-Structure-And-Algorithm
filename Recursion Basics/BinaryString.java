public class BinaryString {
    public static void binaryStirngwithoutOnes(String str, int n, char lastPlace) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // if(lastPlace=='0'){
        // binaryStirngwithoutOnes(str+"0", n-1, '0');
        // binaryStirngwithoutOnes(str+"1", n-1, '1');

        // }
        // else{
        // binaryStirngwithoutOnes(str+"0", n-1, '0');
        // }
        binaryStirngwithoutOnes(str + "0", n - 1, '0'); // call 0 every time
        if (lastPlace == '0') {
            binaryStirngwithoutOnes(str + "1", n - 1, '1');
        }
    }

    public static void binaryStirngwithoutZeros(String str, int n, char lastPlace) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // if(lastPlace=='0'){
        // binaryStirngwithoutOnes(str+"0", n-1, '0');
        // binaryStirngwithoutOnes(str+"1", n-1, '1');

        // }
        // else{
        // binaryStirngwithoutOnes(str+"0", n-1, '0');
        // }
        binaryStirngwithoutZeros(str + "1", n - 1, '1'); // call 0 every time
        if (lastPlace == '1') {
            binaryStirngwithoutZeros(str + "0", n - 1, '0');
        }
    }

    public static void main(String[] args) {
        binaryStirngwithoutOnes(new String(""), 3, '0');
        System.out.println("\n");
        binaryStirngwithoutZeros(new String(""), 3, '1');
    }
}
