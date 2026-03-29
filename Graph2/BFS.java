import java.util.*;
import java.util.LinkedList;

public class BFS {
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

    public static void bfs2(ArrayList<Edge> graph[],boolean vis[]){ //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        if(graph.length==0){
            return ;  // no nodes 
        }
        q.add(0);

        while(!q.isEmpty()){
            int current = q.remove();
            if(!vis[current]){ // not visited 
                vis[current]=true;
                 System.out.print(current+" ");
                 // add all neighbors 
                 for(int i=0;i<graph[current].size();i++){
                    Edge e = graph[current].get(i); // ith Edge 
                    q.add(e.dest);
                 }
            }

            // if already visited then nothing to do 
        }
    }

    public static void main(String[] args) {
        int v = 7; // no if edges
        ArrayList<Edge> graph[] = new ArrayList[v];
        // initialize all index with empty arraylist
        createGraph(graph);
        bfs(graph, new boolean[v]);
        System.out.println();
        bfs2(graph, new boolean[v]);

    }
}
