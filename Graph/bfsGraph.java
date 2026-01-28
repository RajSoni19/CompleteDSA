package Graph;

import java.util.*;

public class bfsGraph {

    public static ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs=new ArrayList<>(); //to store original ans
        Queue<Integer> q=new LinkedList(); 
        boolean vis[]=new boolean[V]; //to mark visited elements
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll(); //pop element from queue
            bfs.add(node); // add it to ans
            for(Integer it:adj.get(node)){ //after poping out element find it neighbour and push it into queue if not visited also mark them visited
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
         ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        
        
        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        int n = ans.size(); 
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" "); 
        }
    }
}
