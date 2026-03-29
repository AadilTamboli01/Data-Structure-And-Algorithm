import java.util.*;

public class TopSortUsingKahnsBFS { // kahns algorithm based on indegreee outdegree
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
        graph[2].add(new Edge(2, 3, 1));

        // node 3
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void calcIndegree(ArrayList<Edge> graph[], int indegree[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topSortUsingKahnsAlgo(ArrayList<Edge> graph[]) {
        int indegree[] = new int[graph.length];
        calcIndegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();
        // add indegree 0 node in the queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            // if neighbor hava indegree 0 add in que else - indegree
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                // not indegree 0
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int v = 6; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        topSortUsingKahnsAlgo(graph);
    }
}
