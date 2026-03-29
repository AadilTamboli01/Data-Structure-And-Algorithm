public class ReverseTheArray {
    public static void reverse(int arr[]) {
        int si = 0, ei = arr.length - 1;
        while (si < ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }

    }

    public static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Before reverse ");
        printarr(arr);
        System.out.println("After reverse ");
        reverse(arr);
        printarr(arr);

    }
}
