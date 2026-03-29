import java.util.*;

public class BubbleSort {
    public static void buubleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int swap = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                System.out.println("Array is already sorted ");
                break;
            }
        }

    }

    // insertion sort
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;

            }
            // insert at the right position

            arr[prev + 1] = current;
        }
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minpose = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minpose] > arr[j]) {
                    minpose = j; // assing the smallest element index to minpose
                }
            }
            // swap
            int temp = arr[minpose];
            arr[minpose] = arr[i];
            arr[i] = temp;
        }
    }

    public static void countingSort(int arr[]) {
        // calculate the largest element
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            largest = arr[i] > largest ? arr[i] : largest;
        }
        // create count array
        int count[] = new int[largest + 1];
        // adding frequency to the count array

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // get the frequency and add to the original array
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 2, 0, 5, 6 };
        int arr2[] = { 1, 2, 3, 4 };
        printArray(arr);
        // Arrays.sort(arr, 0, 3, Collections.reverseOrder());
        countingSort(arr);
        printArray(arr);
    }
}