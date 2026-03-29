import java.util.*;

public class LongestSubArrayWithZeroSum {
    public static int MaxSubArraySumZero(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int MaxLength = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) { // if Sum exist
                // calculate sum
                MaxLength = Math.max(MaxLength, i - map.get(sum)); // index of sum (j-i) i is index of sum in map

            } else {
                // not present sum in map
                map.put(sum, i);
            }
        }
        return MaxLength;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(MaxSubArraySumZero(arr));
    }
}
