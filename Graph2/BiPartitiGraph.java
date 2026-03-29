import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartitiGraph {
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
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // not color
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) { // for all connected components
            if (col[i] == -1) { // not visited not coloured

                q.add(i);
                col[i] = 0; // 0 = yello , 1 = blue
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {// case 1 not visited
                            int nextCol = col[curr] == 1 ? 0 : 1; // oposite color
                            col[e.dest] = nextCol;
                            q.add(e.dest);

                        }else if (col[curr]==col[e.dest]){
                            return false; // case 2 neighbor have same col non bipartite 
                        }
                        // case 3 different color continue 
                    }
                }
            }
        }
        return true;
    }

    // graph coloring algo
    /*
     * 3 case
     * 1 neighbors has same color non bipartite
     * 3) neighbors has differerent color conitunue
     * # no colr
     */

    public static void main(String[] args) {
        int v = 5; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        System.out.println(isBipartite(graph));

    }
}
