package Graph;
import java.util.*;
public class graphstore {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //Matrix
        // int n=sc.nextInt();
        // int m=sc.nextInt();
        // int adj[][]=new int[n+1][n+1];
        // for(int i=0;i<m;i++){
        //     int u=sc.nextInt();
        //     int v=sc.nextInt();
        //     adj[u][v]=1;
        //     adj[v][u]=1;

        // }
        // for(int i=1;i<=n;i++){
        //     System.out.println(Arrays.toString(adj[i]));
        // }

        //List
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<Integer>[] adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj[u].add(v);
            adj[v].add(u); //remove this line for directed graph
        }
        for(int i=1;i<=n;i++){
            System.out.println(adj[i]);
        }
    }
}
