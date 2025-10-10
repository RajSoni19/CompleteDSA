package Arrays;

import java.util.*;

public class Pascaltra{

    public static List<Integer> generaterow(int row){
        long ans=1;
        List<Integer> ansrow=new ArrayList<>();
        ansrow.add(1);
        for(int col=1;col<row;col++){
           ans=ans*(row-col);
           ans=ans/col;
           ansrow.add((int)ans);
        }
        return ansrow;
    }

    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> ans=new ArrayList<>();
        for(int row=1;row<=n;row++){
            ans.add(generaterow(row));
        }
        return ans;

    }
    public static void main(String[] args) {
        int n=5;
        List<List<Integer>> anss=pascalTriangle(n);
        System.out.println(anss);


    }
}