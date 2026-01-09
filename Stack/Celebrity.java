package Stack;

public class Celebrity {

    public static int getcele(int [][]M){

      int n=M.length;
      int top=0;
      int down=n-1;
      while(top<down){
        if(M[top][down]==1){
            top=top+1;
        }
        else if(M[down][top]==1){
            down=down-1;
        }
        // If neither knows each other, both are not the celebrity
        else{
            top++;
            down--;
        }
      }
      
      if(top>down) return -1;


      for(int i=0;i<n;i++){
        if(i==top) continue;
           // If top knows someone or someone doesn't know top, it's not a celebrity
        if(M[top][i]==1 || M[i][top]==0){
           return -1;
        }
      }

      return top;


        //BRUTE
    //    int n=M.length;
    //    int iknow[]=new int[n];
    //    int knowme[]=new int[n];

    //    for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         if(M[i][j]==1){
    //             knowme[j]++;
    //             iknow[i]++;
    //         }
    //     }
    //    }

    //    for(int i=0;i<n;i++){
    //     if(knowme[i]==n-1 && iknow[i]==0){
    //         return i;
    //     }
    //    }

    //    return -1;
    }
    public static void main(String[] args) {
          int[][] M = {
            {0, 1, 1, 0}, 
            {0, 0, 0, 0}, 
            {1, 1, 0, 0}, 
            {0, 1, 1, 0}
        };

        System.out.println(getcele(M));
    }
}
