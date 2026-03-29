public class WordBreakProblem {// google
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord;

        public Node() {
            // initialize the array
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) { // O(L)
            int index = word.charAt(level) - 'a';
            // if character exist
            if (curr.children[index] == null) { // not exist
                curr.children[index] = new Node();

            }
            // child is current
            curr = curr.children[index];
        }
        curr.endOfWord = true; // because all character are inserted
    }

    public static boolean search(String word) {// O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if (curr.children[index] == null) {
                // not exist
                return false;
            }
            // update current
            curr = curr.children[index];

        }
        return curr.endOfWord == true; // if end of word is true then true else not found
    }

    public static boolean wordBreak(String key) { //O(L) liniear  l is length of key 
        if (key.length() == 0) {

            return true;
        }
        // less than eqal beacause last index non inclusive 

        for (int i = 1; i <= key.length(); i++) { // /first index is non inclusive hence i= 1
            // key.substring(0, i); // 0 to i-1
            // key.substring(i); // i to whole length // remianing next level key

            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String word[] = { "i", "like", "sam", "samsumg", "mobile", "ice" };

        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }

        String key = "like";

        System.out.println(wordBreak(key));

    }
}
