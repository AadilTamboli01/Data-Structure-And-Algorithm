
public class UniqueSubstring { // Microsoft
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

    public static int countOfNodes(Node root ){ // same approch as count node from the binary tree 
        if (root ==null){ // no node 
            return 0;
        }

        int count =0;

        // loop on the root children 
        for(int i=0;i<root.children.length;i++){
            if(root.children[i] != null){
                // valid node present 
                count+= countOfNodes(root.children[i]); // now childre is root 
                
            }
        }

        return count +1; // +1 for root node 

    }

    public static void main(String[] args) {
        String str = "ababa";
        String str2 ="aaple";

        // find all prefixes of all suffixes prefixes means trie

        // calculate suffixes and make trie of that suffix bacaause trie stored unique
        // prefixes
        for (int i = 0; i < str2.length(); i++) {
            String s = str2.substring(i); // suffix 
            insert(s); // create trie with all suffixes to create all uniwu prefixes 

        }

        // count bnodes in trie beacause it is no of unique prefixes 
        System.out.println("No of unique prefixes = "+countOfNodes(root));

    }
}
