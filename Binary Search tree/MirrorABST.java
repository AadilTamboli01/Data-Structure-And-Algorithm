import java.util.*;

public class MirrorABST {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;

        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {// left insert
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;

    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void getPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void rootToleaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null) {
            getPath(path);
        }
        rootToleaf(root.left, path);
        rootToleaf(root.right, path);
        path.remove(path.size() - 1); // remove the last node

    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) { // root is < minimum not valid case

            return false;
        } else if (max != null && root.data >= max.data) {
            return false; // root
        }

        // analyze for subtree
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }

    public static Node createMirror(Node root) { // O(n)
        if (root == null) {
            return null; // no child
        }

        Node leftChild = createMirror(root.left);
        Node rightChild = createMirror(root.right);

        // mirror the bst
        root.left = rightChild;
        root.right = leftChild;
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        createMirror(root);
        preOrder(root);

    }
}
