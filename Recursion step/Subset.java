// package Recursion step;
import java.util.*;

public class Subset {

    public static List<List<Integer>> findsub(int nums[]){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> s=new ArrayList<>();
        dfs(0,nums,s,result);
        return result;
    }

    public static void dfs(int i,int nums[],List<Integer> s,List<List<Integer>> result ){
        if(i==nums.length){
            result.add(new ArrayList<>(s));
            return;
        }


        s.add(nums[i]); //include
        dfs(i+1,nums,s,result);
        s.remove(s.size()-1);
        
        dfs(i+1,nums,s,result);//exclude



    }


    public static void main(String[] args) {
        List<List<Integer>> f=new ArrayList<>();
        int nums[]={1,2,3};
        f=findsub(nums);
        System.out.println(f);

    }
}
