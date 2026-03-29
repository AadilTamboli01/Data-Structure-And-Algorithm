import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int vetex;
        int cost;

        public Pair(int vetex, int cost) {
            this.vetex = vetex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // assinding soring on the distance
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) { // cycle
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // create our graph

        // node 2

        // dag
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        // node 3
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    public static void prims(ArrayList<Edge> graph[], int src) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // src and cost to src

        int finalCost = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();
            if (!vis[curr.vetex]) {
                vis[curr.vetex] = true;

                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.vetex].size(); i++) {
                    Edge e = graph[curr.vetex].get(i);
                    // add neighbor and cost in the queuue
                    pq.add(new Pair(e.dest, e.wt));

                }
            }
        }
        System.out.println("FinalCost = " + finalCost);

    }

    public static void main(String[] args) {
        int v = 4; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        prims(graph, 0);

    }
}
