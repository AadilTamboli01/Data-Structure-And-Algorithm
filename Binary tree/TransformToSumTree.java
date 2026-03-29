public class TransformToSumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;

        }
    }

    public static int transformTosum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transformTosum(root.left);
        int rightChild = transformTosum(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;

    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
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

        transformTosum(root);
        preorder(root);
    }
}
