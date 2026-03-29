public class CreationOfSegmentationTrees {
    static int tree[]; // segment tree

    public static void init(int n) {
        tree = new int[4 * n];
    }

    // each index stores subarray sum of arr in range root node stores total
    // subarray sum
    public static int buildST(int arr[], int i, int start, int end) { // i = ith index of segment trees
        // base case
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        buildST(arr, 2 * i + 1, start, mid); // left= 2i+1
        buildST(arr, 2 * i + 2, mid + 1, end);// right = 2i+2

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2]; // current node sum = left sum + right sum

        return tree[i];

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int n = arr.length;
        init(n);
        System.out.println(buildST(arr, 0, 0, arr.length-1));
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }

}