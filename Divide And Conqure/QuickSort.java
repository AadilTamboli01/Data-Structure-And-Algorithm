public class QuickSort {
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                // swap
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // for last swap the pivote index = i+1
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = pivot;
        return i ; // pivot index 

    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int pivotIdx = partition(arr, si, ei);
        // left
        quickSort(arr, si, pivotIdx - 1); // pivote index is fix
        // right
        quickSort(arr, pivotIdx + 1, ei);

    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
