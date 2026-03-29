public class SearchInSOrtedAndRoatatedArray {

    public static int search(int arr[], int target, int si, int ei) {
        // base case
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[si] <= arr[mid]) { // mid on line one
            // case one left part
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                // right part mid ka right part
                return search(arr, target, mid + 1, ei);
            }

        } else {// mid on line 2
                // line 2
                // case right part of mid
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei);
            } else {
                // right part of mid
                return search(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
      System.out.println(search(arr, 0, 0, arr.length));
    }
}
