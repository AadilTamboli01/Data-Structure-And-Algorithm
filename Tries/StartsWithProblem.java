public class StartsWithProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        int frequirency;

        public Node() {
            // initialize the array
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            frequirency = 1; // initialize frequency = 1
        }

    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) { // O(L)
            int index = word.charAt(level) - 'a';
            // if character exist
            if (curr.children[index] == null) { // not exist
                curr.children[index] = new Node(); // with freq 1

            } else {
                // if already exist
                curr.children[index].frequirency++; // increase frequency
            }
            // child is current (updation)
            curr = curr.children[index];
        }
        curr.endOfWord = true; // because all character are inserted
    }

    public static boolean startSWith(String prefix) { //O(l) l is level in prefix string 
        Node curr = root;
        // search for prefix exist
        // end of word no matter
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false; // not exist any word with prefix
            }
            // word exist with prefix starting check for next character of prefix

            // update curr
            curr = curr.children[index];

        }
        return true;
    }

    public static void main(String[] args) {
        String arr[] = { "apple", "app", "mango", "man", "woman" };

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        System.out.println(startSWith("appl"));
    }
}
