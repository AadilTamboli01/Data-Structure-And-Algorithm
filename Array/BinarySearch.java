public class BinarySearch {
    public static int binarySearch(int arr[], int key) {
        int si = 0;
        int ei = arr.length - 1;
       

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }

        }
        return -1;
    }
    

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 8, 9 };
        System.out.println(binarySearch(arr, 5));
    }
}
