package Recursion step;
import java.util.*;

public class GenerateBinaryString1 {

    public static List<String> valid(int n){
        List<String> result=new ArrayList<>();
        backtrack(result,"",n);
        return result;
    }

    public static void backtrack(List<String> result,String curr,int n){
        if(curr.length()==n){
             result.add(curr);
             return;
        } 

        backtrack(result, curr+'1', n);
        if(curr.isEmpty() || curr.charAt(curr.length()-1)=='1'){
            backtrack(result, curr+'0', n);
        }


    }

    public static void main(String[] args) {
      List<String> result=new ArrayList<>();
      result=valid(3);
      System.out.println(result);


   }   
}
