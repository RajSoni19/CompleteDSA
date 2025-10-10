public class WordSearch {
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean result = exist(board, "ABCCED");
        System.out.println(result);
    }

    public static boolean exist(char[][] board, String word) {
        // Method implementation to be added
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board,String word,int i,int j,int index){
        if(index==word.length()){
            return true;
        }

         if(i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j]!=word.charAt(index)){
            return false;
        }

        char temp=board[i][j];
        board[i][j]='£';
        boolean found=dfs(board,word,i+1,j,index+1) ||
                      dfs(board,word,i-1,j,index+1) ||
                      dfs(board,word,i,j+1,index+1) ||
                      dfs(board,word,i,j-1,index+1);
        board[i][j]=temp;

        return found;


    }
}
