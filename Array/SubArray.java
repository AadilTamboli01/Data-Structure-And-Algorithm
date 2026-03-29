public class SubArray {
    public static void subarray(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    currSum += arr[k];
                }
                maxSum = maxSum < currSum ? currSum : maxSum;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Max sum = " + maxSum);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 ,5};
        subarray(arr);
    }
}
