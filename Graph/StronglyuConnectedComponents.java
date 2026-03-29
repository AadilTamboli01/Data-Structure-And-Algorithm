import java.util.*;

public class StronglyuConnectedComponents {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        // neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
        return;
    }

    public static void dfs(ArrayList<Edge> transposeGraph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        // neighbors
        for (int i = 0; i < transposeGraph[curr].size(); i++) {
            Edge e = transposeGraph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(transposeGraph, e.dest, vis);
            }
        }
        return;

    }

    /*
     * kosarusj
     * step 1 = find the topsort Order
     * ste 2 = transpose the graph
     * step 3 = dfs on the transpose graph according to the topsort stack
     */
    public static void kosaRajus(ArrayList<Edge> graph[], int V) { // dfs O(V+E)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < graph.length; i++) { // for all vertex
            if (!vis[i]) {
                topSort(graph, i, vis, s); // step 1 topsort
            }
        }

        ArrayList<Edge> transpose[] = new ArrayList[V];

        // initiallize with empty arraylist
        for (int i = 0; i < graph.length; i++) {
            transpose[i] = new ArrayList<>();

            // visited aur aage kaam ayenga isilie re initialize
            vis[i] = false;
        }

        // step 2 transopose the graph
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src)); // reverse edge dest -> src
            }
        }

        // step 3 dfs on the transpose according to stak nodes
        while (!s.isEmpty()) {
            int curr = s.pop();

            if (!vis[curr]) {
                dfs(transpose, curr, vis);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosaRajus(graph, V);
    }
}
