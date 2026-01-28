package Graph;

import java.util.*;

public class NumberofProvince {

    public static void dfs(int node,List<List<Integer>> adjlist,boolean[] visited){
        visited[node]=true;

        for(int n:adjlist.get(node)){
            if(!visited[n]){
              dfs(n, adjlist, visited);
            }
        }
             
    }

    public static int numprov(int [][]adj,int V){
        List<List<Integer>> adjlist=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
         for(int j=0;j<V;j++){
            if(adj[i][j]==1 && i!=j     ){
                adjlist.get(i).add(j);
                adjlist.get(j).add(i);
            }
         }
        }

        boolean[] visited=new boolean[V];

        int count=0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                count++;
                dfs(i,adjlist,visited);
            }
        }
        return count;

    }
    public static void main(String[] args) {
         int[][] adj = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };
        int V=3;
        System.out.println(numprov(adj,V));
    }
}
