import java.util.ArrayList;

public class CycleDetectionDirectedGraph {
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

    public static void createGraph(ArrayList<Edge> graph[]) { // cycle
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // create our graph

        graph[0].add(new Edge(0, 2, 1));

        // Node 1
        graph[1].add(new Edge(1, 0, 1));

        // node 2
        graph[2].add(new Edge(2, 3, 1));

        // node 3
        graph[3].add(new Edge(3, 0, 1));

        // node 4

    }

    public static boolean iscycle(ArrayList<Edge> graph[]) {
        // if neighbor is exist in stack then cycle
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        // call for conneted componets
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, vis, stack, i)) { // curr is i
                    return true; // kisine bhi false return kardiya
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean vis[], boolean stack[], int curr) { // O(v+e)
                                                                                                           // modified
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest] == true) { // neighbor is in stack
                return true; // cycle
            }
            if (!vis[e.dest]) { // not cisited
                if (isCycleUtil(graph, vis, stack, e.dest)) { // if true
                    return true;
                }
            }

            // visited but not in stack continue

        }

        // at the time of return
        stack[curr] = false;
        return false;

    }

    public static void main(String[] args) {
        int v = 5; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        System.out.println(iscycle(graph));
    }
}
