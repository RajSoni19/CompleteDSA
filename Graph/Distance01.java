package Graph;

import java.util.*;

public class Distance01 {

    public static int[][] nearest(int[][] grid){
        // Multi-source BFS: compute distance of each cell to nearest 1
        int n=grid.length;
        int m=grid[0].length;
        // vis marks whether a cell has been enqueued/processed
        int vis[][]=new int[n][m];
        // dist stores the shortest distance from each cell to any 1
        int dist[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        // Initialize BFS with all cells that contain 1 (distance = 0)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }

        // 4-directional movement (up, right, down, left)
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};

        // Standard BFS traversal
        while(!q.isEmpty()){
            int []cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            int steps=cell[2];

            // The first time we reach a cell is the shortest distance
            dist[row][col]=steps;

            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                // Add unvisited neighbors and increase distance by 1
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new int[]{nrow,ncol,steps+1});
                }

            }
        }
        return dist;

    }
    public static void main(String[] args) {
         int[][] grid = {
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
        };

        int ans[][]=nearest(grid);
        // Print distance matrix
        for(int row[]:ans){
            for(int val:row){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
