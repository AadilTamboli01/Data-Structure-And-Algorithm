public class LongestWordWithAllPrefix {
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

    public static void main(String[] args) {
        
    }
}
