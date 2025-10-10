// package Recursion step;
import java.util.*;
public class Subset1{

    public static  ArrayList<Integer> findsubset(int ans[]){
        int n=ans.length;
         ArrayList<Integer> result=new ArrayList<>();
         helper(0,0,ans,n,result);
        Collections.sort(result);
        return result;
    }

    public static void helper(int ind,int sum,int ans[],int n,ArrayList<Integer> result){
        if(ind==n){
            result.add(sum);
            return;
        }

        helper(ind+1,sum+ans[ind],ans,n,result); //pick
        helper(ind+1,sum,ans,n,result); //dont pick

    }
    public static void main(String[] args) {
           ArrayList<Integer> f=new ArrayList<>();
        int nums[]={3,1,2};
        f=findsubset(nums);
        Collections.sort(f);
        System.out.println(f);



    
    }
}