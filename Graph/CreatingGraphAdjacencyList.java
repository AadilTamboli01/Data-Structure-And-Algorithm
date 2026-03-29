import java.util.*;

public class CreatingGraphAdjacencyList {
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

    public static void main(String[] args) {
        int v = 5; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist 
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // create our graph 
        graph[0].add(new Edge(0, 1, 5));

        //Node 1 
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //node 2 
        graph[2].add(new Edge(2,1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //node 3 
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // node 4 
        graph[4].add(new Edge(4, 2, 2));


    }
}