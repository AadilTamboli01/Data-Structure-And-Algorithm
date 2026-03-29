import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HasPath {
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

        // Node 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // node 2
        graph[2].add(new Edge(2, 0, 1));

        graph[2].add(new Edge(2, 4, 1));

        // node 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // node 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    // bfs
    public static void bfs(ArrayList<Edge> graph[], boolean vis[]) { // O(V+E) vis vertes e edges is nodes in graph
        Queue<Integer> q = new LinkedList<>();

        if (graph.length == 0) {
            return; // no nodes
        }

        // add first elment sourse 0 start from 0
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) { // not visited
                // visit current
                vis[curr] = true;
                System.out.print(curr + " ");

                // add all neighbor in the q
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge currEdge = graph[curr].get(i);
                    // store all the beighbors
                    q.add(currEdge.dest);
                }

            }

        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr) { // O(V+E)
        // base case not reequred because only call if not visited
        // visit currrent
        vis[curr] = true;
        System.out.print(curr + " ");

        // for neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge currEdge = graph[curr].get(i);
            if (!vis[currEdge.dest]) { // if neoghtbors is not visited
                dfs(graph, vis, currEdge.dest); // now neightbors is curr if not visited

            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {// O(V+E)
        if (src == dest) {
            return true; // srourse is our destination
        }

        vis[src] = true; // src is visited
        // call for neighbors
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // for destination
            if (!vis[e.dest]) { // if neighbors is not visited
              if(hasPath(graph, e.dest, dest, vis)){// now destination is our sourse
                // agar destination ne true kara to) true karo nhi to false
                return true;

              } 
            }
        }
        vis[src] = false;
        return false ;
    }

    public static void main(String[] args) {
        int v = 7; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        // bfs(graph, new boolean[v]);
        // dfs(graph, new boolean[v], 0); // curr = 0 starting point

        System.out.println(hasPath(graph, 0, 6, new boolean[v]));

    }
}
