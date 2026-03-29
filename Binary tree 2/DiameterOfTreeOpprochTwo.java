public class DiameterOfTreeOpprochTwo {
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

    public static class Info {
        int diam;
        int height;

        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
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

    public static Info diameterOfTree(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterOfTree(root.left);
        Info rightInfo = diameterOfTree(root.right);

        // diam = max of left diam right diam self diam
        int diam = Math.max(leftInfo.diam, Math.max(rightInfo.diam, leftInfo.height + rightInfo.height + 1));
        int height = Math.max(leftInfo.height, rightInfo.height)+1; // height 

        return new Info(diam, height);

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTreePreOrder(nodes);

        System.out.println();
        System.out.println(sumOfNodes(root));
        System.out.println(diameterOfTree(root).diam);

    }
}
