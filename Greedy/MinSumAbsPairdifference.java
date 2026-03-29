import java.util.Arrays;

public class MinSumAbsPairdifference {
    public static void minDifferenceAbsolute(int A[], int B[]) {
        // sort both in accending bacause the min abs diffence
        Arrays.sort(A);
        Arrays.sort(B);
        int difference = 0;
        for (int i = 0; i < A.length; i++) { // calculation difference
            difference += Math.abs(A[i] - B[i]);
        }
        System.out.println(difference);
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 7, 8 };
        int B[] = { 2, 3, 5, 6 };
        minDifferenceAbsolute(A, B);
    }
}
