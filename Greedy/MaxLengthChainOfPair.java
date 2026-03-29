import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPair {
    public static int maxLength(int pairs[][]) {
        if (pairs.length == 0) {
            return 0;
        }

        // sort pair according to the 2 nd colum
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // add first element in chain always
        int length = 1;
        int lastEnd = pairs[0][1]; // last end

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                // currStart> lastEnd
                length++;
                lastEnd = pairs[i][1]; // update last end

            }
        }
        return length;

    }

    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
   System.out.println("Max length = "+maxLength(pairs));
    }
}
