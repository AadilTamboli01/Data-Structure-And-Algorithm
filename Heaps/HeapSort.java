public class HeapSort {

    public static void heapify(int i, int arr[], int size) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
        int maxIndex = i;
        // for deccending chage the condition for minIndex meanin heap 
        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            heapify(maxIndex, arr, size);
        }
    }

    public static void heapSort(int arr[]) {
        // step 1 heap maxheap
        // hepify for non leaf node
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(i, arr, arr.length);
        }

        // loop for swapping and hepify

        for (int i = arr.length-1; i >= 1; i--) {

            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0, arr, i); // hepify for a0th element and ilength

            // accending hence maxHEap

        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
