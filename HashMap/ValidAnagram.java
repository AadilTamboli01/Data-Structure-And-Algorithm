import java.util.*;

public class ValidAnagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        // add in hash map str1
        for (int i = 0; i < str1.length(); i++) {
            hm.put(str1.charAt(i), hm.getOrDefault(str1.charAt(i), 0) + 1);
        }
        // check for secong string isanagram

        for (int i = 0; i < str2.length(); i++) {
            Character currChar = str2.charAt(i);
            if (!hm.containsKey(currChar)) { // char not in hm
                return false;

            } else {// reduce the frequency
                if (hm.get(currChar) == 1) {
                    hm.remove(currChar); // removegte currChar
                } else {
                    hm.put(currChar, hm.get(currChar) - 1);
                }

            }

        }

        return hm.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "racecar", str2 = "racecr";
        System.out.println(isAnagram(str1, str2));
    }
}
