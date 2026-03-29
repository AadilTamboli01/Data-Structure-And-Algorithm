public class CountOfNodes {
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

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);

        return leftCount + rightCount + 1; // left subtree + right subtree + root
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        System.out.println(count(root));
    }
}
