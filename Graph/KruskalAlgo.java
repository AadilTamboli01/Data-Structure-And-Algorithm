import java.util.*;

public class KruskalAlgo {
    public static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.wt = wt;
            this.src = src;
            this.dest = dest;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edge) {

        edge.add(new Edge(0, 1, 10));
        edge.add(new Edge(0, 2, 15));
        edge.add(new Edge(0, 3, 30));
        edge.add(new Edge(1, 3, 40));
        edge.add(new Edge(2, 3, 50));

    }

    static int n = 4; // no of nodes in the graph vertex
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
        return par[x] = find(par[x]);

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

    public static void kruskals(ArrayList<Edge> edge, int V) {
        init();
        // sort edges
        Collections.sort(edge);// ELOgE
        int mstcost = 0;
        int mstCount = 0;

        for (int i = 0; i < V - 1; i++) {V
            Edge e = edge.get(i);

            // parnt of src and destinaton
            int parA = find(e.src);
            int parB = find(e.dest);

            // no cycle
            if (parA != parB) {
                union(e.src, e.dest);
                mstcost += e.wt;
                mstCount++;
            }

         
        }

        System.out.println(mstcost);

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskals(edges, V);
    }
}
