import java.util.*;

public class TopViewOfBinaryTree {
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
        int hd;
        Node node;

        public Info(int hd, Node node) {
            this.hd = hd;
            this.node = node;
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

    public static void topView(Node root) {
      

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> hm = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(0, root)); // root horizontal distance = 0
        hm.put(0, root);

        while (!q.isEmpty()) {
            Info currInfo = q.remove();

            if (currInfo == null) {

                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // if valid node Info
                if (!hm.containsKey(currInfo.hd)) { // horizontal distance not exist
                    hm.put(currInfo.hd, currInfo.node);

                }

                if (currInfo.node.left != null) {
                    q.add(new Info(currInfo.hd - 1, currInfo.node.left)); // in left hd -1
                    min = Math.min(min, currInfo.hd - 1);
                }
                if (currInfo.node.right != null) {
                    q.add(new Info(currInfo.hd + 1, currInfo.node.right)); // in right hd +1
                    max = Math.max(max, currInfo.hd + 1);
                }

            }
        }

        for(int i=min;i<=max;i++){
            System.out.print(hm.get(i).data+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTreePreOrder(nodes);

        System.out.println();
        System.out.println(sumOfNodes(root));
        topView(root);

    }
}
