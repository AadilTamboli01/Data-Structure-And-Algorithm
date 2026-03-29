public class DeleteANode {

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
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            // left
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }

    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            // right case
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            // left case
            root.left = delete(root.left, val);
        } else {
            // found
            // case 1 leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // casd 2 sngle child
            if (root.right == null) {
                // data in left
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }
            // case 3 both children 2
            // find inorder successor (left most node in the right subtreee)
            Node IS = findInOrderSuccessor(root.right);
            // relplce with is
            root.data = IS.data;
            // delete IS
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static void main(String[] args) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        inOrder(root);
        delete(root, 1);
        System.out.println();
        inOrder(root);
    }
}
