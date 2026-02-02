package Graph;

import java.util.*;

/**
 * Helper class to store a pair of values: node and its parent.
 * Used in BFS queue to track the parent of each visited node.
 */
class BNode {
    int first;   // Current node value
    int second;  // Parent node value (-1 for root/starting node)
    
    BNode(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

/**
 * Cycle Detection in Undirected Graph using BFS.
 * A cycle exists if we encounter a visited node that is NOT the parent of current node.
 */
public class checkCyclebfs {

    /**
     * BFS-based cycle detection for a single connected component.
     * 
     * @param adj - Adjacency list representation of the graph
     * @param s - Starting node for BFS
     * @param vis - Visited array to track visited nodes
     * @param parent - Parent array to track parent of each node (unused in this implementation)
     * @return - true if cycle found, false otherwise
     */
    public static boolean check(ArrayList<ArrayList<Integer>> adj,int s,boolean vis[]){
        // Create a queue to store BNode pairs (node, parent)
        Queue<BNode> q=new LinkedList<>();
        
        // Start BFS from node 's' with parent -1 (no parent for starting node)
        q.add(new BNode(s,-1));
        vis[s]=true;  // Mark starting node as visited
        
        // Process all nodes in current connected component
        while(!q.isEmpty()){
            // Extract node and its parent from queue
            int node=q.peek().first;
            int par=q.peek().second;
            q.remove();
            
            // Check all adjacent nodes of current node
            for(Integer it:adj.get(node)){
                // If adjacent node is not visited, add it to queue
                if(vis[it]==false){
                    q.add(new BNode(it,node));  // Add with current node as parent
                    vis[it]=true;
                }
                // If adjacent node is visited AND it's not the parent of current node,
                // then we found a back edge (cycle detected)
                else if(par!=it) return true;  // Cycle found!
            }
        }

        // No cycle in this component
        return false;
    }

    /**
     * Main function to check if cycle exists in the entire graph.
     * Handles disconnected components by running BFS from each unvisited node.
     * 
     * @param V - Number of vertices in the graph
     * @param adj - Adjacency list representation of the graph
     * @return - true if cycle exists anywhere in graph, false otherwise
     */
    public static boolean iscycle(int V,ArrayList<ArrayList<Integer>> adj){
        // Initialize visited array (all nodes unvisited initially)
        boolean vis[]=new boolean[V];
        Arrays.fill(vis,false);
        
        // Parent array (not actively used in current implementation)
        // int parent[]=new int[V];
        // Arrays.fill(parent,-1);

        // Process each connected component
        for(int i=0;i<V;i++){
            // If node is not visited, start BFS from it
            if(vis[i]==false){
                // If cycle found in this component, return true
                if(check(adj,i,vis)) return true;
            }
        }
        
        // No cycle found in any component
        return false;
    }
    
    /**
     * Test method demonstrating cycle detection on a sample graph.
     * Graph structure:
     *   1 -- 2
     *        |
     *        3
     * This graph contains a cycle: 1-2-3-2-1
     */
    public static void main(String[] args) {
         // Create adjacency list for 4 nodes (0, 1, 2, 3)
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        
        // Add edges (undirected graph, so add both directions)
        adj.get(1).add(2);  // Edge from 1 to 2
        adj.get(2).add(1);  // Edge from 2 to 1
        adj.get(2).add(3);  // Edge from 2 to 3
        adj.get(3).add(2);  // Edge from 3 to 2
        
        // Check and print if cycle exists
        // Expected output: true (because 2-3-2 forms a cycle)
        System.out.println(iscycle(4,adj));
    }
}
