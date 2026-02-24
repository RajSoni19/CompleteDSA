package Graph;

import java.util.*;
// import java.util.List;

// import LinkedList.LinkedList;

public class checkcycleTopo {

    public static boolean hascycle(int V,List<List<Integer>> adj){
        int indeg[]=new int[V];
        for(int i=0;i<V;i++){
            for(int v:adj.get((i))){
                indeg[v]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0) q.add(i);
        }

        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;
            for(int n:adj.get(node)){
                indeg[n]--;
                if(indeg[n]==0){
                    q.add(n);
                }
            }
        }
        return cnt!=V; //there will cycle if topological array size is not same  as n 
    }
    public static void main(String[] args) {
         int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        System.out.println(hascycle(V,adj));
    }
}
