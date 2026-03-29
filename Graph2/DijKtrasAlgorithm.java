import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijKtrasAlgorithm {
    // kahns algorithm based on indegreee outdegree
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
        int n;
        int dist;

        public Pair(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; // assinding soring on the distance
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) { // cycle
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // create our graph

        // node 2

        // dag
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        // node 3
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static void dijkras(ArrayList<Edge> graph[], int src) { // O(v+elogv)
        int dist[] = new int[graph.length]; // dist[i] = dist [src to i]
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // add src
        pq.add(new Pair(src, 0)); // src t o sr distance = 0

        while (!pq.isEmpty()) { // bfs
            Pair current = pq.remove();

            // if distance not calculated
            if (!vis[current.n]) {
                vis[current.n] = true; // visit means shortest is calculated

                // visit neighbors

                for (int i = 0; i < graph[current.n].size(); i++) {
                    Edge e = graph[current.n].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // calculation for short distance
                    if (dist[u] + wt < dist[v]) {
                        // relaxation
                        dist[v] = dist[u] + wt;
                        // add distance in pq
                        pq.add(new Pair(v, dist[v]));

                    }

                }
            }

        }
        // print distance
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        int v = 6; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        dijkras(graph, 0);
    }
}
