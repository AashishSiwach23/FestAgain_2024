import java.util.*;

// Class to represent a graph
class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency List for storing edges
    
    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }
    
    // Method to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's adjacency list
    }
    
    // DFS utility function
    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        
        // Recur for all the vertices adjacent to this vertex
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    
    // DFS traversal method
    void DFS(int v) {
        // Mark all vertices as not visited (set as false by default)
        boolean[] visited = new boolean[V];
        
        // Call the recursive DFSUtil to print DFS traversal from a given vertex
        DFSUtil(v, visited);
    }
    
    // Driver code
    public static void main(String[] args) {
        Graph g = new Graph(6); // Create a graph with 6 vertices

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        
        System.out.println("DFS starting from vertex 0:");
        g.DFS(0); // Start DFS traversal from vertex 0
    }
}
