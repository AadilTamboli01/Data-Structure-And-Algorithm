import java.lang.reflect.Array;
import java.util.ArrayList;

public class LowestCommonAnsestor {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        // find in the left and right subtree
        boolean leftFound = getPath(root.left, n, path);
        boolean rightfound = getPath(root.right, n, path);

        //
        if (rightfound || leftFound) {
            return true; // dono mese
        }

        // if not in any then root not in path
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);

        getPath(root, n2, path2);

        int i = 0;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        // i-1 is lca
        Node lca = path1.get(i - 1);
        return lca;

    }

    public static Node lca2(Node root, int n1, int n2) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root; // root as ancestor
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {

            return leftLca;
        }

        return root; // n1 in left and n2 in right subtree 
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lca(root, 4, 5).data);
    }
}
