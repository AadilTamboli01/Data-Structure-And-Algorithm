import java.lang.reflect.Array;
import java.util.*;

public class mergeTwoBst {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;

        }
    }

   

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    // create bst
    public static Node createBSt(ArrayList<Integer> mergeInOrder, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        Node root = new Node(mergeInOrder.get(mid));

        // left and right subtree

        root.left = createBSt(mergeInOrder, start, mid - 1);
        root.right = createBSt(mergeInOrder, mid + 1, end);

        return root;
    }

    public static Node mergebSts(Node root1, Node root2) {

        // inorder 1
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(root1, inorder1);

        // inorder 2
        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(root2, inorder2);

        // sort
        ArrayList<Integer> merge = new ArrayList<>();
        int i = 0; // inorder1
        int j = 0; // inorder 2

        while (i <= inorder1.size() - 1 && j <= inorder2.size() - 1) {
            // inorder1 is less
            if (inorder1.get(i) <= inorder2.get(j)) {
                merge.add(inorder1.get(i));
                i++;
            } else {
                merge.add(inorder2.get(j));
                j++;
            }

           
        }
        // for remaining element
        while (i <= inorder1.size() - 1) { // inorder 1
            merge.add(inorder1.get(i));
            i++;
        }

        while (j <= inorder2.size() - 1) { // inorder 2
            merge.add(inorder2.get(j));
            j++;
        }

        // create balance bst using merge array
        return   createBSt(merge, 0, merge.size() - 1);

    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2); // tree 1
        root1.left = new Node(1);
        root1.right = new Node(4);

        // tree 2
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node newRoot = mergebSts(root1, root2);

        preOrder(newRoot);

    }
}
