import org.w3c.dom.Node;

public class CountOfNodes {

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

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);

        postOrder(root.right);
        System.out.print(root.data + " ");

    }
    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);
        return left+right+1;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTreePreOrder(nodes);
        postOrder(root);
        System.out.println();
        System.out.println(countOfNodes(root));
    }
}
