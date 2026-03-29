import java.util.*;
public class PrefixProblem {
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

    public static void findPrefix(Node root, String ans,ArrayList<String> answer) { //O(L) levels in trie 

        // base case
        if (root == null) {
            return;
        }
        if(root.frequirency==1){
          answer.add(ans); // add ans in arraylist 
            return;
        }

        // serach each childre of root
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                // if character present
                findPrefix(root.children[i], ans + (char) (i + 'a'),answer); // add current character
            }
        }
    }

    public static void main(String[] args) {
        String word[] = { "zebra", "dog", "duck", "dove" };

        root.frequirency = -1; // dummy frequncy
        ArrayList<String > ans = new ArrayList<>();
        findPrefix(root, "", ans);
        System.out.println(ans);

    }
}
