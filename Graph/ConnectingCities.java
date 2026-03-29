import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {
     
        int dest;
        int cost;

        public Edge( int dest, int cost) {
            this.dest = dest;
 
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    // no need t o create graph

    public static int connectingCitie(int cities[][]) { // same time complexity as prims 
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge( 0, 0)); // src is destination

        int finalCost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;
                // for neighbors
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    // if edge exisit
                    if (cities[curr.dest][i] != 0) { // i is destination 
                        pq.add(new Edge(i,cities[curr.dest][i]));
                    }
                }

            }
        }
        return  finalCost;
    }

    public static void main(String[] args) { // prims algorithm
        int n = 4; // no of vertex

        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

                System.out.println(connectingCitie(cities));

    }

}
