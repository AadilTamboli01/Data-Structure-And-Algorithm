public class DisJointSetUnionDS {
    static int n = 7; // no of nodes in the graph
    static int par[] = new int[n];
    static int rank[] = new int[n]; // initially 0

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

    }

    public static int find(int x) { // find parent of x
        if (x == par[x]) {
            return x;
        }

        // return find(par[x]);

        /// path compression 
         return  par[x] = find(par[x]);

    }

    public static void union(int A, int B) {
        int parA = find(A);
        int parB = find(B);

        if (rank[parA] == rank[parB]) {
            // make parent is A
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            // b is parent
            par[parA] = parB; // no rank update

        } else {
            par[parB] = parA;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(find(1));
        union(1, 3);
        System.out.println(find(3));
    }
}
