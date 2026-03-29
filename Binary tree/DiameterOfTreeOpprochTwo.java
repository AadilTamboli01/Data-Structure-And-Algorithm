public class DiameterOfTreeOpprochTwo {

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

    public static class Info {
        int height;
        int diameter;

        public Info(int height, int diameter) {
            this.diameter = diameter;
            this.height = height;
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

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0); // diameter and height both 0

        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                leftInfo.height + rightInfo.height + 1);  //chcke for diameter left right and self diameter 
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(height, diameter);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        System.out.println(diameter(root).diameter);
    }
}
