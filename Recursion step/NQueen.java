import java.util.*;
public class NQueen {

    public static List<List<String>> solveQueen(int n){
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.'; //empty cell
            }
        }

        List<List<String>> res=new ArrayList<List<String>>();
        int leftRow[]=new int[n];
        int upperDiagonal[]=new int[2*n-1];
        int lowerDiagonal[]=new int[2*n-1];
        solve(0,board,res,leftRow,lowerDiagonal,upperDiagonal);
        return res;

    }

    public static List<String> construct(char[][] board){
        List<String> res=new LinkedList<String>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void solve(int col,char[][] board,List<List<String>> res,int leftRow[],int upperDiagonal[],int lowerDiagonal[]){
        if(col==board.length){
            res.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[board.length-1+col-row]==0){
               board[row][col]='Q';
               leftRow[row]=1;
               lowerDiagonal[row+col]=1; //formula is generated refer notes
               upperDiagonal[board.length-1+col-row]=1; //formula is generated refer notes
               solve(col+1,board,res,leftRow,upperDiagonal,lowerDiagonal);
               board[row][col]='.';
               leftRow[row]=0;
               lowerDiagonal[row+col]=0;
               upperDiagonal[board.length-1+col-row]=0;
            }
        }
    }
    public static void main(String[] args) {
        int N=4;
        List<List<String>> queen=solveQueen(N);
        int i=1;
        // for(List <String> it:queen){
        //     System.out.println("Arragement " + i);
        //     for(String s:it){
        //         System.out.println(s);
        //     }
        //     System.out.println();
        //     i+=1;
        // }
        System.out.println(queen);
    }
}
