import java.util.*;

public class AllPathsFromSourseToTarget { // kahns algorithm based on indegreee outdegree
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

        // node 2

        // dag
        graph[0].add(new Edge(0, 3, 1));

        graph[2].add(new Edge(2, 3, 1));

        // node 3
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void allPathsSrctoDest(ArrayList<Edge> graph[], int src, int dest, String path) { // O(v^v)
        // base case
        if (src == dest) {
            System.out.println(path + dest);

            return;
        }
        // add src in path

        // for neighbors
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            allPathsSrctoDest(graph, e.dest, dest, path + src); // destination src
        }
        // remove the src from path not have pah

        return;

    }

    public static void main(String[] args) {
        int v = 6; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        allPathsSrctoDest(graph, 5, 1, "");
    }
}
