public class SubtreeOfAnotherTree {
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

    public static int index = -1;

    public static Node buildTree(int nodes[]) {
        index++;
        if (nodes[index] == -1) {
            return null; // no children
        }
        Node newNode = new Node(nodes[index]); // create a new NOde

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode; // as a root node
    }

    public static boolean isIdentical(Node node, Node subroot) {
        if (node == null && subroot == null) {
            return true; // both are null
        } else if (node == null || subroot == null || node.data != subroot.data) {
            return false;
        }

        // check in right and left subtree

        if (!isIdentical(node.left, subroot.left)) { // if not identical
            return false;
        }
        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }

        return true; // else identical
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false; // subroot not found in main tree
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        // check in left and right subtree for ans

        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right, subRoot);

        return leftAns|| rightAns;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = new Node(1);
        root.right = new Node(3);
        root.left= new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left= new Node(6);
        root.right.right= new Node(7);
        // Node root = buildTree(nodes);
     
        Node subroot = root.left;
        System.out.println(isSubtree(root, subroot));
    }
}
