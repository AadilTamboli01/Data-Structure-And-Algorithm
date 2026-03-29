import java.util.ArrayList;

public class CycleDetectionUndirectedGraph {
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // create our graph
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        // Node 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // node 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // node 3
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        // node 4

        graph[4].add(new Edge(4, 3, 1));

    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {// parent of current = -1 )
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {

        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // 3 cases 1 ) neighbor is not visited visit neighbr 2) neighbor is visited but
            // parent continue 3) neighbor is visisted nut not parent cycle

            if (!vis[e.dest]) { // parent = e.src
                if (detectCycleUtil(graph, vis, e.dest, e.src)) {
                    return true;
                } else if (vis[curr] && e.dest != par) { // neighbors is visited but not parent
                    return true; // cycle

                }
                // parent and visited continue
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        System.out.println(detectCycle(graph));

    }
}
