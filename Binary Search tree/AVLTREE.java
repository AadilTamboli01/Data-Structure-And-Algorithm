public class AVLTREE {
    public static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }

    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static int getBalace(Node root) {
        if (root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node X) {
        Node y = X.right;
        Node T2 = y.left;

        // perform rotation
        y.left = X;
        X.right = T2;

        // calculate height
        X.height = Math.max(height(X.left), height(X.right)) + 1;
        y.height = Math.max(height(y.right), height(y.left)) + 1;

        // new root is y
        return y;

    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // rotation
        x.right = y;
        y.left = T2;

        // height
        x.height = Math.max(height(x.right), height(x.left)) + 1;
        y.height = Math.max(height(y.right), height(y.left)) + 1;

        // x as a root
        return x;

    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val); // return new root
        }

        if (val < root.data) { // left insert
            root.left = insert(root.left, val);

        } else if (val > root.data) {
            // right insert
            root.right = insert(root.right, val);
        } else { // duplicate element val == root.data
            return root; // duplicate keys not allowed

        }
        // update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // get balace bafctor
        int bf = getBalace(root);

        // cases for roatation
        // left left case // data inser in left of left
        if (bf > 1 && val < root.left.data) { // leftme insert hoga to bf > 1 hojaega
            return rightRotate(root); // right rotate of root

        }
        // rith right case insert in right of right and bf - <-1
        if (bf < -1 && val > root.right.data) {
            return leftRotate(root);
        }
        // left right case
        if (bf > 1 && val > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // right left case
        if (bf < -1 && val < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root; // aval already balance
    }

    public static void main(String[] args) {
        root = insert(root, 10);

        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }

}
