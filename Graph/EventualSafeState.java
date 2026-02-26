package Graph;

import java.util.*;

public class EventualSafeState {

    public static List<Integer> getterminal(int V,List<Integer>[] adj){
        List<Integer>[] adjRev=new List[V];
        int ingdeg[]=new int[V];
        for(int i=0;i<V;i++){
            adjRev[i]=new ArrayList<>();
        }
        for(int i=0;i<V;i++){
            for(int n:adj[i]){
                adjRev[n].add(i);
                ingdeg[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(ingdeg[i]==0){
                q.add(i);
            }
        }

       while(!q.isEmpty()){
        int node=q.poll();
        ans.add(node);
        for(int parent:adjRev[node]){
            ingdeg[parent]--;
            if(ingdeg[parent]==0){
                q.add(parent);
            }
        }
       }
       Collections.sort(ans);
       return ans;
    }
    public static void main(String[] args) {
         List<Integer>[] adj = new ArrayList[12];
        for (int i = 0; i < 12; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1);
        adj[1].add(2);
        adj[2].add(3);
        adj[2].add(4);
        adj[3].add(4);
        adj[4].add(5);
        adj[5].add(6);
        adj[6].add(7);
        adj[8].add(1);
        adj[8].add(9);
        adj[9].add(10);
        adj[10].add(8);
        adj[11].add(9);

        int V = 12;  // Number of nodes in the graph
        List<Integer> safe=getterminal(V,adj);
        System.out.println(safe);

    }
}
