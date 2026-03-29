import java.util.*;

public class LevelOrderTraversal {
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

    public static void levelOrderTravel(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println();

                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");

                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        levelOrderTravel(root);
    }
}
