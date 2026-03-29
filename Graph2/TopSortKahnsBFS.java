import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopSortKahnsBFS {
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
        for (int i = 0; i < graph.length; i++) { // i = current vertex
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++; // destinatuin par jaar to indegree of destinatuon ++
            }
        }
    }

    public static void topSortUsingKahnsAlgo(ArrayList<Edge> graph[]) { //BFFS 
        int indegree[] = new int[graph.length];
        calcIndegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();
        // add indegree 0 node in the queue

        for (int i = 0; i < indegree.length; i++) { // add vettes with indegree 0
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // dfs
        while (!q.isEmpty()) {
            int current = q.remove();
            System.out.print(current + " ");
            // indegree 0 means all dependency covered 

            for (int i = 0; i < graph[current].size(); i++) {
                // all ni=eighbors if current
                Edge e = graph[current].get(i);
                indegree[e.dest]--; // direct neighbors l indegree -- kardo 
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) { // indegree outdgree based kahns algo
        int v = 6; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        topSortUsingKahnsAlgo(graph);
    }
}
