public class InsertionInTrie {

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
        for (int level = 0; level < word.length(); level++) { //O(L)
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

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };

        // insert all the string
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
    }

}