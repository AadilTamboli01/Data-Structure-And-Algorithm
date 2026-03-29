public class PrerixSum {
    public static void maxSumOfSubarray(int arr[]) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        // calulate the prefix
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];

        }
        // int maxSum
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = 0;
                if (i == 0) {
                    currSum = prefix[j];
                } else {
                    currSum = prefix[j] - prefix[i - 1];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("MaxSum = " + maxSum);
    }

    public static void kadnas(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("MaxSum = "+maxSum);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        maxSumOfSubarray(arr);
        kadnas(arr);
    }
}
