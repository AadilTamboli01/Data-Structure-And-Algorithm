import java.util.ArrayList;

public class ArticulationPoint {

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

        graph[4].add(new Edge(4, 3));

    }

    // O(V+E) dfs modified

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int lowt[], int time, boolean vis[],
            boolean[] ap) { // tarjan
        // dfs
        vis[curr] = true;
        dt[curr] = lowt[curr] = ++time;
        int children = 0;

        // all neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (e.dest == par) { // neigbor is parent
                continue; // ignore

            } else if (vis[e.dest]) {
                // neighbor is visited
                lowt[curr] = Math.min(lowt[curr], dt[e.dest]); // calculate the lowest dtime

            } else {
                // neighbor is not visited and not parent
                dfs(graph, e.dest, e.src, dt, lowt, time, vis, ap);
                // after dfs low
                lowt[curr] = Math.min(lowt[curr], lowt[e.dest]); // neigbor is not parent

                // check for articalation point
                if (par != -1 && dt[curr] <= lowt[e.dest]) { // condition 2 and 3 // signle node and starting of cycle
                    ap[curr] = true;
                }
                children++; // unvisited node is children
            }
        }

        // condition 1 ;; starting point of graph and disconnected children is >1

        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getArticulationPointTarjan(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int lowt[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < graph.length; i++) {

            if (!vis[i]) {
                dfs(graph, i, -1, dt, lowt, time, vis, ap);
            }
        }

        //  print articulation point 
        for(int i=0;i<ap.length;i++){
            if(ap[i]){
                System.out.println("AP : "+i);
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getArticulationPointTarjan(graph, V);
    }
}
