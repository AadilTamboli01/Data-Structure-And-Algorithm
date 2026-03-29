import java.util.*;

public class TopviewOfBinaryTree {
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
        Node node;
        int hd; // horizontal distaance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        // level order travel
        if (root == null) {
            return; // no node in the tree
        }

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> hm = new HashMap<>();
        int min = 0;
        int max = 0;

        // level order traversa;
        q.add(new Info(root, 0)); // horizontal dianace of the root = 0
        q.add(null); // add null for next line

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) { // null on the current
                if (q.isEmpty()) {
                    break; // q is empty
                } else {
                    q.add(null); // add null for next level
                }
            } else {
                if (!hm.containsKey(curr.hd)){
                     // if horizontal distance not exist then add
                hm.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) { // left me data hai
                    q.add(new Info(curr.node.left, curr.hd - 1)); // in left hd --
                    // left is min
                    min = Math.min(min, curr.hd - 1); // min and next elemnet min

                }
                if (curr.node.right != null) {
                    // right me data hai
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    // right having max
                    max = Math.max(max, curr.hd + 1); // max and next right element hd

                }
            }
        }
        // print element from min to maximum horo=izonta diatance
        for (int i = min; i <= max; i++) {
            System.out.print(hm.get(i).data);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}
