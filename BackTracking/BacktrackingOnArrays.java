import java.util.*;

public class BacktrackingOnArrays {

    public static void changeArr(int arr[], int idx, int value) {
        if (idx == arr.length) {

            printArr(arr);
            return;
        }
        // recursion call
        arr[idx] = value;
        changeArr(arr, idx + 1, value + 1); // call for next index

        // backtracking
        arr[idx] = arr[idx] - 2;

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        System.out.println("array in main function ");
        changeArr(arr, 0, 1);
        System.out.println();
        printArr(arr);
    }
}
