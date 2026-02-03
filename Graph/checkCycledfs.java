package Graph;

import java.util.ArrayList;

public class checkCycledfs {

    public static boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        // Mark current node as visited
        visited[node]=true;
        // Explore all neighbors
        for(int neightbour:adj.get(node)){
            // If neighbor is not visited, recurse with current node as parent
            if(!visited[neightbour]){
                if(dfs(neightbour,node,adj,visited)) return true;
            }
            // If neighbor is visited and is not the parent, a cycle exists
            else if(neightbour!=parent){
               return true;
            }
        }
        // No cycle found in this path
        return false;
    }

    public static boolean  iscycle(int V,ArrayList<ArrayList<Integer>> adj){
        // Visited array for all vertices
        boolean[] visited=new boolean[V];
        // Handle disconnected components
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,-1,adj,visited)) return true;
            }
        }
        // No cycle in any component
        return false;
    }
    public static void main(String[] args) {
         int V = 5;
           ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add edges
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);

        // Print whether the undirected graph contains a cycle
        System.out.println(iscycle(V,adj)); 
    }
}
