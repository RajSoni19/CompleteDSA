package Graph;

import java.util.ArrayDeque;

public class NumberOfEnclaves {

    public static int bfs(int[][] grid){
        if(grid.length==0) return 0;
        int n=grid.length;
        int m=grid[0].length;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){  //boundary(cannot be part of answer)
                    if(grid[i][j]==1 && !vis[i][j]){
                        vis[i][j]=true;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

        while(!q.isEmpty()){
            int []curr=q.poll(); //taking boundray element and travsersing in all 4 direction
            int row=curr[0],col=curr[1];
            for(int k=0;k<4;k++){
                int nrow=row+delrow[k];
                int ncol=col+delcol[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    vis[nrow][ncol]=true;
                    q.add(new int[]{nrow,ncol});
                }
            }
        }

         // Count remaining land cells as enclaves.
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]) cnt++;
            }
        }
        return cnt;

    }

    // Mark all land cells connected to the boundary as safe.
    // public static void dfs(int r,int c,int [][]vis,int [][]mat,int []dr,int []dc){
    //     vis[r][c]=1;
    //     int n=mat.length;
    //     int m=mat[0].length;
    //     for(int k=0;k<4;k++){
    //         int nr=r+dr[k];
    //         int nc=c+dc[k];
    //         if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && mat[nr][nc]==1){
    //             dfs(nr,nc,vis,mat,dr,dc);
    //         }
    //     }
    // }

    // // Count land cells not connected to any boundary land.
    // public static int count(int n,int m,int[][] mat){
    //     int[] dr={-1,0,1,0};
    //     int[] dc={0,1,0,-1};
    //     int vis[][]=new int[n][m];
    //     // Traverse boundary rows.
    //     for(int j=0;j<m;j++){
    //         if(vis[0][j]==0 && mat[0][j]==1) dfs(0,j,vis,mat,dr,dc);
    //         if(vis[n-1][j]==0 && mat[n-1][j]==1) dfs(n-1,j,vis,mat,dr,dc);
    //     }

    //     // Traverse boundary columns.
    //     for(int i=0;i<n;i++){
    //         if(vis[i][0]==0 && mat[i][0]==1 ) dfs(i,0,vis,mat,dr,dc);
    //         if(vis[i][m-1]==0 && mat[i][m-1]==1) dfs(i,m-1,vis,mat,dr,dc);
    //     }

    //     // Count remaining land cells as enclaves.
    //     int cnt=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(vis[i][j]==0 && mat[i][j]==1) cnt++;
    //         }
    //     }
    //     return cnt;
// }
        public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        System.out.println("Number of enclaves: " + bfs(grid));
    }
}
