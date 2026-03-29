import java.text.CollationElementIterator;
import java.util.*;
public class FindMaxInArray{

    public static int max(ArrayList<Integer> list){

        int max= Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            max = Math.max(max,list.get(i));
        }
        return max;
    }
 public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(-1);
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
    System.out.println(max(list));
    
    // multi dimentional arraylist 

 }
}