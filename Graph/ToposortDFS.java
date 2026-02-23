package Graph;
import java.util.*;

public class ToposortDFS {


    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int vis[],Stack<Integer> st){
        vis[node]=1; // mark node as visited as visited
        for(int it:adj.get(node)){
            if(vis[it]==0){ // if node not visited perform dfs
                dfs(it,adj,vis,st);
            }
        }
        st.push(node); // push every visited node in stack
    }


    public static ArrayList<Integer>  toposort(int V,ArrayList<ArrayList<Integer>> adj){
        int vis[]=new int[V]; // to mark every node as visited
        Stack<Integer> st=new Stack<>(); // to store order of topological sort
        for(int i=0;i<V;i++){
            if(vis[i]==0){ // if node not visited perform dfs
                dfs(i,adj,vis,st);
            }
        }

        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){ // after visisting all nodes pop out all nodes for correct order ans;
            ans.add(st.pop());
        }
        return ans;

    }
    public static void main(String[] args) {
           int V = 6;

        // Create adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println(toposort(V,adj));
    }
}
