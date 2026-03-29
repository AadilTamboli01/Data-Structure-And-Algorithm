import java.util.ArrayList;

public class MinDistancebetweenTwoNodes {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;

        }
    }

    public static boolean getpath(Node root, int n, ArrayList<Node> path) { // find path for node
        if (root == null) {
            return false;

        }
        path.add(root);
        if (root.data == n) {
            return true;

        }
        // calculate pat hfor left and right
        boolean foundLeft = getpath(root.left, n, path);
        boolean foundright = getpath(root.right, n, path);
        if (foundLeft || foundright) {
            return true;
        }
        // agar kahi bhi nahi mila matlab current root bhi path ka part nahi remove
        // current root from path
        path.remove(path.size() - 1); // current root hamesha path k lase me hoga
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        // for calculate path store in t his arraylist
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // for finding last common ancestor
        getpath(root, n1, path1);
        getpath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) { // last comoon ansestor jab tak equal hai
                break;
            }

        }
        // last equal node = lca
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

    public static int lcaDiatance(Node root, int n1) {
        if (root == null) {
            return -1;
        }
        if (root.data == n1) {
            return 0;
        }
        // find in left and right
        int leftdis = lcaDiatance(root.left, n1);
        int rightdis = lcaDiatance(root.right, n1);

        if (leftdis == -1 && rightdis == -1) {
            return -1;
        }
        if (leftdis == -1) {
            return rightdis + 1;
        } else {
            return leftdis + 1;
        }

    }

    public static int distance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);

        return lcaDiatance(lca, n1) + lcaDiatance(lca, n2);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int n1 = 4, n2 = 5;

      
        System.out.println(distance(root, n1, n2));
    }
}
