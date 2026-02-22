package Graph;

public class checkDirecteddfs {

    public static boolean dfscheck(int node,int edges[][],int vis[],int pathvis[]){
        vis[node]=1;
        pathvis[node]=1;
        // For adjacency matrix:
        // edges[node][neighbor] == 1 means node -> neighbor.
        for(int neighbor = 0; neighbor < edges[node].length; neighbor++){
            if(edges[node][neighbor] == 1){
                // when neighbor is not visited
                if(vis[neighbor]==0){
                    if(dfscheck(neighbor, edges, vis, pathvis)==true) return true;
                }
                // if the neighbor has been previously visited
                // and it exists in the current DFS path, cycle found
                else if(pathvis[neighbor]==1){
                    return true;
                }
            }
        }
        pathvis[node]=0;
        return false;
    }


    public static boolean iscycle(int v,int edges[][]){
        int vis[]=new int[v];
        int pathvis[]=new int[v];

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(dfscheck(i,edges,vis,pathvis)==true) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // Keep size 8 because one edge uses node 7.
        int v = 8;

        // Adjacency matrix for directed graph.
        // Default value 0 = no edge.
        // Value 1 = directed edge exists from row node to column node.
        int[][] edges = new int[v][v];

        // Same edges as adjacency-list input:
        // 1 -> 2, 2 -> 3, 3 -> 4, 3 -> 7, 4 -> 5
        edges[1][2] = 1;
        edges[2][3] = 1;
        edges[3][4] = 1;
        edges[3][7] = 1;
        edges[4][5] = 1;

        System.out.println(iscycle(v,edges));
       
    }
}
