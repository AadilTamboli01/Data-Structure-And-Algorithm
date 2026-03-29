import java.util.*;
import java.util.function.IntUnaryOperator;

public class UnionAndInterSection {
    public static void uinioInterSection(int arr[], int arr2[]) {
        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> intersection = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        // count union
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        // union
        for (Integer it : set) {
            union.add(it); // add data
        }
        System.out.println("no of element in union = " + union.size());
        System.out.println("Union");
        for (int i = 0; i < union.size(); i++) {
            System.out.print(union.get(i) + " ");
        }
        System.out.println();

        // intersection
        // clear set
        set.clear();

        // add arr1 in set
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        // calculate the intersetion
        for (int i = 0; i < arr2.length; i++) { // loop on  arr2 
            if(set.contains(arr2[i])){
                intersection.add(arr2[i]);

                set.remove(arr2[i]);// remove the element from set 
            }

        }
        System.out.println("count of intersection element = "+intersection.size());
        System.out.println("intersection");
        for(int i=0;i<intersection.size();i++){
            System.out.print(intersection.get(i)+" ");
        }

    }

    public static void main(String[] args) {
int arr1[]={7,3,9};
int arr2[]= {6,3,9,2,9,4};
uinioInterSection(arr1, arr2);
    }
}
