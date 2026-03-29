import java.util.*;

public class FindItenarary {
    public static String getstart(HashMap<String, String> tickets) {

        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) { // calculate the revMap
            revMap.put(tickets.get(key), key); // reverse

        }
        // find starting point
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;// starting point
            }
        }
        return null;
    }

    public static void printItenerary(HashMap<String, String> tickets){
        String start = getstart(tickets);
        // print itenerary 
        System.out.print(start+" -> ");
        for(String key : tickets.keySet()){
         System.out.print(tickets.get(start)+" -> ");

         // update start 
         start = tickets.get(start);
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("chennai", "Begaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "chennai");
        tickets.put("Delhi", "Goa");

        printItenerary(tickets);

    }
}
