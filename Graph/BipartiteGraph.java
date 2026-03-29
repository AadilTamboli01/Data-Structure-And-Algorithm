import java.util.*;

public class BipartiteGraph {
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
        // graph[0].add(new Edge(0, 3, 1));

        // Node 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // node 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // node 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        // node 4

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];

        // initoalise with -1
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        // for all nodes connetcted compomnents
        for (int i = 0; i < graph.length; i++) {
            // agar ith ko color bhi diya
            if (col[i] == -1) { // give initlal color =0 means yellow 1 mens blue
                q.add(i); // add in the queue
                col[i] = 0; // give yellow color

                // perform bfs
                while (!q.isEmpty()) {
                    int curr = q.remove();

                    // for neighbors
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) { // no color
                            // calculate next color
                            int nextCol = col[curr] == 0 ? 1 : 0; // opposite color
                            col[e.dest] = nextCol;
                            // addd inthe q
                            q.add(e.dest);
                        } else if (col[curr] == col[e.dest]) { // neighbor has same col
                            return false; // not bipartite
                        }
                        // case 3 neighbor has differnt color continue
                    }

                }

            }
        }
        return true;

    }

    public static void main(String[] args) {
        int v = 5; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        // bfs(graph);
        // dfs(graph); // curr = 0 starting point

        // System.out.println(hasPath(graph, 0, 6, new boolean[v]));
        System.out.println(isBipartite(graph));

    
    }
}
