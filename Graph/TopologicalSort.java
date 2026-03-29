import java.util.*;

public class TopologicalSort {
    
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

        // node 4

    }

    public static void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>(); // for topoogical sorting

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                // not visited
                topSortUtil(graph, stack, vis, i); // modified dfs
            }
        }
        // print stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static void topSortUtil(ArrayList<Edge> graph[], Stack<Integer> stack, boolean vis[], int curr) { // modified
                                                                                                             // dfs

        vis[curr] = true; // visited of current is true

        // neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // current edge
            if (!vis[e.dest]) { // if neighbors is not visited
                topSortUtil(graph, stack, vis, e.dest); // neighbors is current
            }

        }
        // add in the stack
        stack.push(curr);
        return;

    }

    public static void main(String[] args) {
        int v = 6; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        topSort(graph);
    }
}
