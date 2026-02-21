package Graph;

import java.util.*;

/**
 * Bipartite Graph Detection
 * 
 * A bipartite graph is a graph whose vertices can be divided into two disjoint sets
 * such that every edge connects a vertex in one set to a vertex in the other set.
 * 
 * This class provides two approaches:
 * 1. Using ArrayList (adjacency list) - efficient for sparse graphs
 * 2. Using 2D array (adjacency matrix) - efficient for dense graphs
 * 
 * Time Complexity: O(V + E) for both approaches
 * Space Complexity: O(V) for ArrayList approach, O(V^2) for Matrix approach
 */
public class Bipartite {

    /**
     * DFS method for ArrayList-based adjacency list representation
     * 
     * @param node Current node being processed
     * @param col Color to assign (0 or 1)
     * @param color Array storing color of each node (-1 = unvisited, 0 or 1 = colored)
     * @param adj Adjacency list representation of graph
     * @return true if subtree is bipartite, false otherwise
     */
    public static boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>> adj) {
        // Assign current color to the current node
        color[node] = col;
        
        // Iterate through all adjacent nodes
        for (int it : adj.get(node)) {
            // If adjacent node is not colored yet
            if (color[it] == -1) {
                // Recursively color it with opposite color (0->1, 1->0)
                if (dfs(it, 1 - col, color, adj) == false) 
                    return false;
            } 
            // If adjacent node has same color as current node, not bipartite
            else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if graph is bipartite using ArrayList representation
     * 
     * @param V Number of vertices in the graph
     * @param adj Adjacency list representation of the graph
     * @return true if graph is bipartite, false otherwise
     */
    public static boolean isbiprate(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize color array: -1 means unvisited
        int color[] = new int[V];
        for (int i = 0; i < V; i++) 
            color[i] = -1;
        
        // Check each unvisited node (handles disconnected components)
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                // Start DFS coloring from node i with color 0
                if (dfs(i, 0, color, adj) == false) 
                    return false;
            }
        }
        return true;
    }
    /**
     * DFS method for adjacency matrix representation
     * 
     * @param node Current node being processed
     * @param col Color to assign (0 or 1)
     * @param color Array storing color of each node (-1 = unvisited, 0 or 1 = colored)
     * @param adjMatrix Adjacency matrix where adjMatrix[i][j] = 1 means edge exists
     * @return true if subtree is bipartite, false otherwise
     */
    public static boolean dfsMat(int node, int col, int color[], int[][] adjMatrix) {
        // Assign current color to the current node
        color[node] = col;
        
        // Check all other vertices for edges from current node
        for (int i = 0; i < adjMatrix.length; i++) {
            // If edge exists from node to i (adjMatrix[node][i] == 1)
            if (adjMatrix[node][i] == 1) {
                // If adjacent node is not colored yet
                if (color[i] == -1) {
                    // Recursively color it with opposite color
                    if (dfsMat(i, 1 - col, color, adjMatrix) == false) 
                        return false;
                } 
                // If adjacent node has same color, not bipartite
                else if (color[i] == col) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if graph is bipartite using adjacency matrix representation
     * 
     * @param V Number of vertices in the graph
     * @param adjMatrix Adjacency matrix where adjMatrix[i][j] = 1 means edge exists between i and j
     * @return true if graph is bipartite, false otherwise
     */
    public static boolean isBipartiteMat(int V, int[][] adjMatrix) {
        // Initialize color array: -1 means unvisited
        int color[] = new int[V];
        for (int i = 0; i < V; i++) 
            color[i] = -1;
        
        // Check each unvisited node (handles disconnected components)
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                // Start DFS coloring from node i with color 0
                if (dfsMat(i, 0, color, adjMatrix) == false) 
                    return false;
            }
        }
        return true;
    }

    /**
     * Main method to demonstrate bipartite graph detection using both approaches
     * 
     * Graph Structure:
     *    0 --- 2
     *    |     |
     *    3 --- 1
     * 
     * This forms a bipartite graph with sets {0, 1} and {2, 3}
     */
    public static void main(String[] args) {
        // ========== Example 1: Using ArrayList (Adjacency List) ==========
        // Create adjacency list for 4 vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges (undirected graph - add both directions)
        adj.get(0).add(2);  // Edge 0-2
        adj.get(2).add(0);
        adj.get(0).add(3);  // Edge 0-3
        adj.get(3).add(0);
        adj.get(1).add(3);  // Edge 1-3
        adj.get(3).add(1);
        adj.get(2).add(3);  // Edge 2-3
        adj.get(3).add(2);
        
        // Check if bipartite using ArrayList approach
        System.out.println("Using ArrayList: " + isbiprate(4, adj));

        // ========== Example 2: Using Adjacency Matrix ==========
        // Create adjacency matrix for the same graph
        // Matrix[i][j] = 1 means edge exists between vertices i and j
        int[][] adjMatrix = {
            {0, 0, 1, 1},  // Vertex 0 connects to 2, 3
            {0, 0, 0, 1},  // Vertex 1 connects to 3
            {1, 0, 0, 1},  // Vertex 2 connects to 0, 3
            {1, 1, 1, 0}   // Vertex 3 connects to 0, 1, 2
        };
        
        // Check if bipartite using Matrix approach
        System.out.println("Using Matrix: " + isBipartiteMat(4, adjMatrix));
    }
}
