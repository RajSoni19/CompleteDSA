package Graph;
import java.util.*;
public class KahnalgoBFS {

    public static int[] kahntopo(int V,ArrayList<ArrayList<Integer>> adj){
        int []indegree=new int[V]; //array for indegree for each node
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++; // calcalute indegree of every node
            }
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0){ // if indegree of any node is 0 then push to queue
                q.add(i);
            }
        }

        int topo[]=new int[V]; //store topological order
        int idx=0;

        while(!q.isEmpty()){
            int node=q.poll(); 
            topo[idx++]=node; // pop out vertex from queue and add it to answer
            for(int it:adj.get(node)){ // Loop through adjacent vertices of the current node
                indegree[it]--; //Reduce in-degree of connected vertex
                if(indegree[it]==0){ // // If in-degree becomes zero, push it to queue
                    q.add(it);
                }
            }
        }
        return topo;
    }
    public static void main(String[] args) {
          int V = 6;
        // Create adjacency list
        ArrayList<ArrayList<Integer>>  adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new java.util.ArrayList<>());
        }

        // Adding edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int ans[]=kahntopo( V,adj);
        for(int i:ans){
            System.out.println(i + " ");
        }
    }
}
