import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {
    static int index = -1;

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node buildTreePreOrder(int nodes[]) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[index]);

        newNode.left = buildTreePreOrder(nodes);
        newNode.right = buildTreePreOrder(nodes);
        return newNode;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);

        return left + right + root.data;
    }

    public static int heightOftree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOftree(root.left);
        int rightHeight = heightOftree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiam = diameterOfTree(root.left);
        int leftHeight = heightOftree(root.left);

        int rightDiam = diameterOfTree(root.right);
        int rightHeight = heightOftree(root.right);

        int selfDiam = leftHeight + rightHeight + 1;
        return Math.max(selfDiam, Math.max(rightDiam, leftDiam));

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTreePreOrder(nodes);

        System.out.println();
        System.out.println(sumOfNodes(root));
        System.out.println(diameterOfTree(root));

    }
}
