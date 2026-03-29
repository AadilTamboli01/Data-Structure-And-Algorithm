public class KthLevelOfTree {
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

    public static void kthlevel(Node root, int level, int k) { // also solve using level order traversal
        if (root == null) { // this preorder is 
            return;
        }
        if(level==k){
            System.out.print(root.data);
        }
        kthlevel(root.left, level+1, k);
        kthlevel(root.right, level+1, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.left= new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left= new Node(6);
        root.right.right= new Node(7);

         kthlevel(root, 1, 3);
    }
}
