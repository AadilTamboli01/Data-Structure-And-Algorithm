import java.util.ArrayList;

public class BridgeInGraph {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));


    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int lowt[], boolean vis[], int time) {

        vis[curr] = true;
        dt[curr] = lowt[curr] = ++time; // intializs all with time

        // neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue; // continue bridge hai ya nai bol nhi salte
            } else if (!vis[e.dest]) {// neighbors is not visited
                dfs(graph, e.dest, e.src, dt, lowt, vis, time);

                // calculate low discovery time at backtracking
                lowt[curr] = Math.min(lowt[curr], lowt[e.dest]); // curr , neightbor

                // bridge condition
                if (dt[curr] < lowt[e.dest]) {
                    System.out.println("Bridge : " + curr + " -> " + e.dest);

                }

            } else {
                // neighbor is visited ans not parent 
                lowt[curr] = Math.min(lowt[curr], dt[e.dest]); // when neightbor is visited compare with discovery time
            }
        }
    }

    public static void getTarjansBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V]; // discovery time
        int lowt[] = new int[V]; // lowest descovery time

        int time = 0;
        boolean[] vis = new boolean[V];

        for (int i = 0; i < graph.length; i++) { // all vertex
            if (!vis[i]) {
                dfs(graph, i, -1, dt, lowt, vis, time); // parent is -1 for initial node
            }

        }

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getTarjansBridge(graph, V);
    }
}
