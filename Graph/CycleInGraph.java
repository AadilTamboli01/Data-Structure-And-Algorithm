import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInGraph {
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

    // cycle detection by using modified dfs

    public static boolean detectCycle(ArrayList<Edge> graph[]) { //O(V+E)
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    // connected components // parent for the inital node is -1

                    return true;
                }
            }
        }
        return false;
    }

    /*
     * 3 case 1) visited but not parenmt true
     * case 2 ) visieted nut parent continue
     * 2) not visited vist the node
     */
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true; // visite the curent node

        // curent k neighbor par loop chala do
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) { // case not visisted
                // neighbor is not visited
                if (detectCycleUtil(graph, vis, e.dest, curr)) { // now curr is parnent and dest is curr
                    return true; // ager neioghbor ne bola true then true

                }
            } else if (vis[curr] && e.dest != par) { // case visited and not parent
                return true;

            }
            // and case parent and visited do nothing
        }
        return false;
    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean vis[], int curr) { // O(V+E)
        // base case not reequred because only call if not visited
        // visit currrent
        vis[curr] = true;
        System.out.print(curr + " ");

        // for neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge currEdge = graph[curr].get(i);
            if (!vis[currEdge.dest]) { // if neoghtbors is not visited
                dfsUtil(graph, vis, currEdge.dest); // now neightbors is curr if not visited

            }
        }
    }

    public static void main(String[] args) {
        int v = 5; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        // bfs(graph);
        // dfs(graph); // curr = 0 starting point

        // System.out.println(hasPath(graph, 0, 6, new boolean[v]));

        System.out.println(detectCycle(graph));
    }
}
