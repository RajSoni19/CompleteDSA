package Graph;

public class SurroundedRegions {

    // Depth-first search to mark all 'O' cells connected to a boundary 'O'.
    // These cells should NOT be flipped because they are not fully surrounded.
    public static void dfs(int r,int c,int [][]vis,char [][]mat,int []dr,int []dc){
        vis[r][c]=1;
        int n=mat.length;
        int m=mat[0].length;
        for(int k=0;k<4;k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && mat[nr][nc]=='O'){
                dfs(nr,nc,vis,mat,dr,dc);
            }
        }
    }

    // Flips all 'O' regions that are completely surrounded by 'X'.
    // 1) DFS from boundary 'O's to mark safe cells.
    // 2) Any unvisited 'O' is surrounded and gets flipped to 'X'.
    public static char[][] fill(int n,int m,char[][] mat){
        if(n==0 || m==0) return mat;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int vis[][]=new int[n][m];
        // Check first and last row for boundary 'O's.
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && mat[0][j]=='O') dfs(0,j,vis,mat,dr,dc);
            if(vis[n-1][j]==0 && mat[n-1][j]=='O') dfs(n-1,j,vis,mat,dr,dc);
        }

        // Check first and last column for boundary 'O's.
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && mat[i][0]=='O') dfs(i,0,vis,mat,dr,dc);
            if(vis[i][m-1]==0 && mat[i][m-1]=='O') dfs(i,m-1,vis,mat,dr,dc);
        }

        // Flip all unvisited 'O's to 'X' (they are surrounded).
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && mat[i][j]=='O') mat[i][j]='X';
            }
        }
        return mat;
    }
    public static void main(String[] args) {
          // Example grid.
          char[][] mat = {
            {'X','X','X','X'},
            {'X','O','X','X'},
            {'X','O','O','X'},
            {'X','O','X','X'},
            {'X','X','O','O'}
        };

        // Solve and print the grid after flipping surrounded regions.
        char[][] ans=fill(mat.length,mat[0].length,mat);
        for(int i=0;i<ans.length;i++){
             for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+ " ");
             }
             System.out.println();
        }

    }
}
