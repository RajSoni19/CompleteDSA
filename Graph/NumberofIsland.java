package Graph;

import java.util.*;

class Pair{
    int first;
    int second;
    // Stores a cell coordinate: (row, col)
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class NumberofIsland {


    // BFS from one starting land cell and mark the whole connected component as visited.
    // This code treats all 8 directions as connected (horizontal, vertical, diagonal).
    public static void bfs(int row,int col,int vis[][],char [][]grid){
        // Mark source cell visited and push it into queue.
        vis[row][col]=1;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int n=grid.length;
        int m=grid[0].length;

        // Standard BFS loop.
        while(!q.isEmpty()){
            int ro=q.peek().first;
            int co=q.peek().second;
            q.remove();

            // Visit all neighbouring cells around (ro, co).
            // delrow/delcol from -1 to +1 gives 8 directions + the current cell.
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow=ro+delrow; 
                    int ncol=co+delcol;

                    // Valid unvisited land cell -> mark and enqueue.
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }

    // Counts connected components of '1' in the grid.
    // For every unvisited land cell, run one BFS and increase island count.
    public static int getcnt(char grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }

    // Time Complexity: O(n*m), each cell is processed at most once in BFS.
    // Space Complexity: O(n*m) for visited array and BFS queue in worst case.
    public static void main(String[] args) {
        char grid[][]={
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
};
System.out.println(getcnt(grid));
    }
}
