public class KthAncestorOfNode {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;

        }
    }

    public static int kethAncestor(Node root, int k, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0; // distance from n to n
        }
        int leftdis = kethAncestor(root.left, k, n);
        int rightdis = kethAncestor(root.right, k, n);

        if (leftdis == -1 && rightdis == -1) {
            // n not found\
            return -1;
        }
        int max = Math.max(leftdis, rightdis);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1; // for next level
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

      System.out.println();
      kethAncestor(root, 1, n2);
    }
}
