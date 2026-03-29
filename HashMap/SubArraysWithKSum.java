import java.util.*;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class SubArraysWithKSum {
    public static int kSum(int arr[],int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // sum count
        int sum = 0;
        int count = 0;
        map.put(0,1); //put always 
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
          if(map.containsKey(sum-k)){ //if SumExist 
            count+= map.get(sum-k);

          }
          // add the sum 
          map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        System.out.println(kSum(arr, -10));
    }
}
