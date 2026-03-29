import java.util.*;

public class SizeOfLargestBSTInBT {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;

        }
    }

    public static class Info {
        boolean isBst;
        int size;
        int min;
        int max;

        public Info(boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {// left insert
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;

    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void getPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void rootToleaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null) {
            getPath(path);
        }
        rootToleaf(root.left, path);
        rootToleaf(root.right, path);
        path.remove(path.size() - 1); // remove the last node

    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) { // root is < minimum not valid case

            return false;
        } else if (max != null && root.data >= max.data) {
            return false; // root
        }

        // analyze for subtree
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }

    public static Node createMirror(Node root) { // O(n)
        if (root == null) {
            return null; // no child
        }

        Node leftChild = createMirror(root.left);
        Node rightChild = createMirror(root.right);

        // mirror the bst
        root.left = rightChild;
        root.right = leftChild;
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBst(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);

        root.left = createBst(arr, start, mid - 1);
        root.right = createBst(arr, mid + 1, end);
        return root;

    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBst2(ArrayList<Integer> inorder, int start, int end) { // arraylist form of create bst
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(inorder.get(mid));

        root.left = createBst2(inorder, start, mid - 1);
        root.right = createBst2(inorder, mid + 1, end);
        return root;

    }

    public static Node bstToBalanceBSt(Node root) {
        // inorder sequence
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInorder(root, inOrder);

        // inorder seq to balance bst
        root = createBst2(inOrder, 0, inOrder.size() - 1);
        return root;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int maxBSt = 0;

    public static Info isBst(Node root) {
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = isBst(root.left);
        Info rightInfo = isBst(root.right);

        // size
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        // invalid bst condition
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) { // equal for no duplicate
            return new Info(false, size, min, max); // not bst 

        }
        // true bst condtion 
        if(leftInfo.isBst && rightInfo.isBst){
            // comapre for max valid mst
            maxBSt=Math.max(maxBSt, size);
            return new Info(true, size, min, max);
        }
        // root node is not valid bst 
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        // preOrder(root);
        // System.out.println();
        // root = bstToBalanceBSt(root);
        // preOrder(root);

        isBst(root);
        System.out.println("this is maxBSt "+maxBSt);
    }
}
