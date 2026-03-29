import java.util.*;

public class MajorityElement {

    public static void majorityElement(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        // add element in hashmap
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer nums : hm.keySet()){
            if(hm.get(nums)>arr.length/3){
                System.out.print(nums+" ");
            }
        }
    }

    public static void main(String[] args) {
int arr[]={1,3,2,5,1,3,1,5,1,1,2,1,2,2,2,2,1,1,22,2,};
majorityElement(arr);
    }
}