import java.util.ArrayList;
import java.util.List;

public class GenerateParanthsis {

    public static List<String> isvalid (int n){
        List<String> result=new ArrayList<>();
        place(result,"",0,0,n);
        return result;
    }

    public static void place(List<String> result,String curr,int open,int close,int n){
        if(curr.length()==2*n){
            result.add(curr);
            return;
        }

        if(open<n){
            place(result,curr+'(',open+1,close,n);
        }
        if(close<open){
            place(result,curr+')',open,close+1,n);
        }
    }
    public static void main(String[] args) {
         List<String> result=new ArrayList<>();
      result=isvalid(3);
      System.out.println(result);
    }
}
